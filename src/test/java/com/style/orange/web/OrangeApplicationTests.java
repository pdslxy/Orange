package com.style.orange.web;

import com.style.orange.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrangeApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void contextLoads() {
        List<SysUser> list = new ArrayList<>();
        SysUser sysUser = new SysUser();
        sysUser.setLoginName("xixi");
        list.add(sysUser);
        list.add(sysUser);
        stringRedisTemplate.opsForHash().put("123","asd",list);
    }

}
