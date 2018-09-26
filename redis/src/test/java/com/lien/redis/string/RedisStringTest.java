package com.lien.redis.string;

import com.lien.redis.client.RedisClient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lienquan on 2018/9/26.
 */
public class RedisStringTest {

    public static final String key = "testKey";

    private RedisString redisString;

    @Before
    public void setUp() throws Exception {
        redisString = new RedisString(RedisClient.getClient());
    }


    @Test
    public void testRedisStringPut(){
        String value = "testValue";
        System.out.println(redisString.put(key, value));
    }

    @Test
    public void testRedisStringGet(){
        System.out.println(redisString.get(key));
    }

    @Test
    public void testRedisStringDel(){
        System.out.println(redisString.del(key));
    }
}