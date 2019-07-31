package com.lien.hashed_map;

import collections.map.HashedMap;

/**
 * Description: <br>
 *
 * @author li
 * @date 2019-07-15 19:55
 */
public class HashMapTest2 {


    public static void main(String[] args){
        HashedMap map = new HashedMap(2);
        for(int i = 0; i < 10000; i++){
            map.put(i,i);
        }
    }

}
