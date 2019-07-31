package com.lien.hashed_map;


import collections.map.HashedMap;

import java.util.Map;

/**
 * Description: <br>
 *
 * @author li
 * @date 2019-07-11 18:28
 */
public class DataHandler {

    private Map<Long, String> data;


    public void M2(){
        System.out.println("[" + Thread.currentThread().getName() + "]" + "开始执行M2");
        data = new HashedMap();
        for(long i = 0; i < 100000L; i++){
//            System.out.println("[" + Thread.currentThread().getName() + "]" + "put data=" + System.identityHashCode(data));
            data.put(i, i+"");
        }
        System.out.println("[" + Thread.currentThread().getName() + "]" + "执行M2完毕");
    }

}
