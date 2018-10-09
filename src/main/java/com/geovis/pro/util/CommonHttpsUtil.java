package com.geovis.pro.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class CommonHttpsUtil {
	
	/* 
     * HTTP接口连接访问实现
     */
	private static HttpURLConnection getHttpUrlConnection(String serviceUrl, String method) throws IOException {
    	URL url = new URL(serviceUrl);
    	HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
    	httpConn.setRequestMethod(method);
        httpConn.setDoInput(true);
        httpConn.setDoOutput(true);
        return httpConn;
    }
	  
    public static String getResult(HttpURLConnection httpConn) throws IOException{  
        StringBuffer buffer = new StringBuffer();  
        //将返回的输入流转换成字符串
        try(InputStream inputStream = httpConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);)
        {  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            String result = buffer.toString();  
            return result;  
        } 
    }
    
    public static String doHttpGet(String uri) throws IOException {
    	try{
    		HttpURLConnection httpConn = getHttpUrlConnection(uri, "GET");
    		return getResult(httpConn);
    	}catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }

    public static String doHttpPost(String uri, String data,boolean jsonType) throws IOException {
        try{
        	HttpURLConnection httpConn = getHttpUrlConnection(uri, "POST");
        	if (jsonType){
        		httpConn.setRequestProperty("Content-Type",  "application/json"); 
        	}
        	setBytesToStream(httpConn.getOutputStream(), data.getBytes());
            return getResult(httpConn);
        }catch(Exception e){
        	e.printStackTrace();
        	return null;
        } 
    }
    
    /* 
     * HTTPS接口连接访问实现
     */

    private static final class DefaultTrustManager implements X509TrustManager {
        @Override
        //该方法检查客户端的证书，若不信任该证书则抛出异常。由于我们不需要对客户端进行认证，因此我们只需要执行默认的信任管理器的这个方法。
        //JSSE中，默认的信任管理器类为TrustManager。
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        //该方法检查服务器的证书，若不信任该证书同样抛出异常。
        //通过自己实现该方法，可以使之信任我们指定的任何证书。在实现该方法时，也可以简单的不做任何处理，即一个空的函数体，由于不会抛出异常，它就会信任任何证书。
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        //返回受信任的X509证书数组。
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    
    
    //获取https url连接
    private static HttpsURLConnection getHttpsURLConnection(String serviceUrl, String method) throws IOException {
        //SSLContext表示安全套接字协议的实现
    	SSLContext ctx = null;
        try {
        	//Transport Layer Security 安全传输层协议（TLS）用于在两个通信应用程序之间提供保密性和数据完整性。
            //该协议由两层组成： TLS 记录协议（TLS Record）和 TLS 握手协议（TLS Handshake）。
        	//其他的还有SSL
            ctx = SSLContext.getInstance("SSL");
            
            //KeyManager[] 第一个参数是授权的密钥管理器，用来授权验证。
            //TrustManager[] 第二个是被授权的证书管理器，用来验证服务器端的证书。
            //SecureRandom() 第三个参数是一个随机数值，可以填写null。
            //如果只是服务器传输数据给客户端来验证，就传入第一个参数就可以，客户端构建环境就传入第二个参数。双向认证的话，就同时使用两个管理器。
            ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //获取socket连接工厂
        SSLSocketFactory ssf = ctx.getSocketFactory();

        
        //URL url = new URL(serviceUrl);
        URL url = new URL(null,serviceUrl,new sun.net.www.protocol.https.Handler());
        //HttpsURLConnection是一个抽象
        HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
        
        //配置连接
        httpsConn.setSSLSocketFactory(ssf);
        httpsConn.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
        });
        httpsConn.setRequestMethod(method);
        httpsConn.setDoInput(true);
        httpsConn.setDoOutput(true);
        return httpsConn;
    }
    
    

    private static byte[] getBytesFromStream(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] kb = new byte[1024];
        int len;
        while ((len = is.read(kb)) != -1) {
            baos.write(kb, 0, len);
        }
        byte[] bytes = baos.toByteArray();
        baos.close();
        is.close();
        return bytes;
    }

    private static void setBytesToStream(OutputStream os, byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        byte[] kb = new byte[1024];
        int len;
        while ((len = bais.read(kb)) != -1) {
            os.write(kb, 0, len);
        }
        os.flush();
        os.close();
        bais.close();
    }

    public static byte[] doHttpsGet(String uri) throws IOException {
    	try{
    		HttpsURLConnection httpsConn = getHttpsURLConnection(uri, "GET");
    		return getBytesFromStream(httpsConn.getInputStream());
    	}catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }

    public static byte[] doHttpsPost(String uri, String data) throws IOException {
        HttpsURLConnection httpsConn = getHttpsURLConnection(uri, "POST");
        setBytesToStream(httpsConn.getOutputStream(), data.getBytes());
        return getBytesFromStream(httpsConn.getInputStream());
    }
}
