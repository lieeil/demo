package com.lien.redis.client;


import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by lienquan on 2018/9/26.
 */
class RedisClientTest {

    @Test
    public void testRedis() {
        Jedis client = RedisClient.getClient();
        System.out.println(client.get("1"));
    }
}