package com.lien.redis.hash;

import com.lien.redis.client.RedisClient;
import com.lien.redis.string.RedisString;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lienquan on 2018/9/26.
 */
public class RedisHashTest {

    public static final String MAP_KEY = "testMap";

    private RedisHash redisHash;

    @Before
    public void setUp() throws Exception {
        redisHash = new RedisHash(RedisClient.getClient());
    }


    @Test
    public void putSingleMapValue() throws Exception {
        System.out.println(redisHash.putSingleMapValue(MAP_KEY, "1","2"));
    }

    @Test
    public void getMapValue() throws Exception {
        System.out.println(redisHash.getMapValue(MAP_KEY, "1"));
    }

    @Test
    public void deleteMapKey() throws Exception {
        System.out.println(redisHash.deleteMapKey(MAP_KEY, "1"));
    }

}