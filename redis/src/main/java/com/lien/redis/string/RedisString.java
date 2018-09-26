package com.lien.redis.string;

import com.lien.redis.client.RedisClient;
import redis.clients.jedis.Jedis;

/**
 * Description: <br>
 *
 * @author li
 * @date 2018/9/26 下午7:24
 */
public class RedisString {

    private Jedis jedis;

    public RedisString(Jedis jedis){
        this.jedis = jedis;
    }

    public String put(String key, String value){
        return jedis.set(key, value);
    }

    public String get(String key){
        return jedis.get(key);
    }

    public Long del(String key){
        return jedis.del(key);
    }
}
