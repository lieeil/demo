package com.lien.redis.client;

import redis.clients.jedis.Jedis;

/**
 * Description: redis客户端 <br>
 *
 * @author li
 * @date 2018/9/26 下午6:52
 */
public class RedisClient {

    private static Jedis client;

    public static Jedis getClient(){
        if(client == null){
            synchronized (RedisClient.class){
                if(client == null){
                    RedisClient restClientHelper = new RedisClient();
                }
            }
        }
        return client;
    }

    private RedisClient(){
        client = new Jedis("localhost");
    }
}
