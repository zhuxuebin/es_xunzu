package com.zxb.xunzu.entity;

import com.zxb.xunzu.EsXunzuProjectApplicationTests;
import com.zxb.xunzu.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xuery on 2018/5/9.
 */
public class UserRepositoryTests extends EsXunzuProjectApplicationTests{

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne(){
        User user = userRepository.findOne(1L);
        Assert.assertEquals("wali", user.getName());
    }
}
