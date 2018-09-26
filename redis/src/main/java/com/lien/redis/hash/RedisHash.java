package com.lien.redis.hash;

import redis.clients.jedis.Jedis;

/**
 * Description: <br>
 *
 * @author li
 * @date 2018/9/26 下午7:46
 */
public class RedisHash {

    private Jedis jedis;

    public RedisHash(Jedis jedis){
        this.jedis = jedis;
    }

    /**
     * 存储单一行数据
     * @param mapName
     * @param mapKey
     * @param value
     * @return
     */
    public Long putSingleMapValue(String mapName, String mapKey, String value){
        return jedis.hset(mapName, mapKey, value);
    }

    /**
     * 得到map中的key
     * @param mapName
     * @param key
     * @return
     */
    public String getMapValue(String mapName, String key){
        return jedis.hget(mapName, key);
    }

    /**
     * 删除map中的key
     * @param mapName
     * @param key
     * @return
     */
    public Long deleteMapKey(String mapName, String key){
        return jedis.hdel(mapName, key);
    }
}
