package com.imooc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("name","zhangsan");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }
}
