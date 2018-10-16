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
        System.out.println(redisHash.putSingleMapValue(MAP_KEY, "1","0.002"));
        System.out.println(redisHash.putSingleMapValue(MAP_KEY, "10","0.02"));
        System.out.println(redisHash.putSingleMapValue(MAP_KEY, "100","0.2"));
        System.out.println(redisHash.putSingleMapValue(MAP_KEY, "1000","2"));
        System.out.println(redisHash.putSingleMapValue(MAP_KEY, "10000","20"));
        System.out.println(redisHash.putSingleMapValue(MAP_KEY, "100000","200"));
        System.out.println(redisHash.putSingleMapValue(MAP_KEY, "1000000","2000"));
    }

    @Test
    public void getMapValue() throws Exception {
        System.out.println(redisHash.getMapValue(MAP_KEY, "1"));
        System.out.println(redisHash.getMapValue(MAP_KEY, "10"));
        System.out.println(redisHash.getMapValue(MAP_KEY, "100"));
        System.out.println(redisHash.getMapValue(MAP_KEY, "1000"));
        System.out.println(redisHash.getMapValue(MAP_KEY, "10000"));
        System.out.println(redisHash.getMapValue(MAP_KEY, "100000"));
    }

    @Test
    public void deleteMapKey() throws Exception {
        System.out.println(redisHash.deleteMapKey(MAP_KEY, "1"));
    }

}