
/**
 * @Title		: AopTestController.java   
 * @Package		: com.geovis.pro.rest   
 * @Description	: 
 * @author		: liuyan     
 * @date		: 2018年11月2日 下午5:36:01   
 * @version		: V1.0 
 */

package com.geovis.pro.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @class : AopTestController
 * @author: liuyan
 * @Descr : 
 */
@RestController
@RequestMapping(value = "/rest")
@Api("AopTestController相关的api")
public class AopTestController {
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "test", notes = "test")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Result test(@RequestParam boolean throwException) throws Exception {
        // case 1
        if (throwException) {
            System.out.println("throw an exception");
            throw new Exception("mock a server exception");
        }

        // case 2
        System.out.println("test OK");
        return new Result() {{
            this.setId(111);
            this.setName("mock a Result");
        }};
    }

    public static class Result {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
