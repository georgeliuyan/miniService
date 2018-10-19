package com.geovis.pro.test;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geovis.pro.dao.SysUserDao;
import com.geovis.pro.model.SysUserEntity;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
	@Resource
    private SysUserDao userDao;

    @Test
    @Transactional
    @Rollback(false)
    public void testSave() {
        SysUserEntity user = new SysUserEntity();
        user.setUsername("wuwii");
        user.setPassword("123");
        userDao.save(user);
        Assert.assertEquals(user.getUsername(), userDao.query(user).get(0).getUsername());
    }

}
