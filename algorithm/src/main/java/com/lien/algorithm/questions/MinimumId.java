package com.lien.algorithm.questions;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * Description: 最小ID<br>
 * 从一堆无序整数数组中，找到最小可用的整数
 * @author li
 * @date 2018/10/29 下午7:12
 */
public class MinimumId {



    public static void function01(Integer n, Integer[] ids){
        int minimum = -1;
        for(int i = 0; i <= n; i++){
            boolean contain = false;
            for(int j = 0; j < ids.length; j++){
                if(ids[j] == i){
                    contain = true;
                    break;
                }
            }
            if(!contain){
                minimum = i;
                break;
            }
        }
        System.out.println(minimum);
    }

    public static void function02(Integer n, Integer[] ids){
        int minimum = -1;
        Boolean[] flayArray = new Boolean[n+1];
        for(int i = 0; i < ids.length; i++){
            if(ids[i] <= n){
                flayArray[ids[i]] = true;
            }
        }
        for(int i = 1; i < flayArray.length; i++){
            if(flayArray[i] == null){
                minimum = i;
                break;
            }
        }
        System.out.println(minimum);
    }

    public static void main(String[] args){
        Integer n = 100;
        Integer[] ids = generateIds(2000);
        function01(ids.length,ids);
        function02(ids.length,ids);
    }

    public static Integer[] generateIds(Integer n){
        Integer[] ids = new Integer[n];
        for(int i = 0; i < n; i++){
            ids[i] = i;
        }
        Random random = new Random();
        Integer index = random.nextInt(n);
        System.out.println(index);
        ids[index] = n+1;
        return ids;
    }

}
