package com.lien.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: <br>
 *
 * @author li
 * @date 2019-07-31 17:14
 */
public class SlideWindowArrayMaxEle {


    public static Integer[] findSlideWindowArrayMaxEle(Integer[] nums, int k){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            Integer[] subNums = new Integer[k];
            int j = 0;
            while (j < k){
                subNums[j] = nums[i + j];
                j++;
            }
            result.add(findMax(subNums));
        }
        Integer[] array = new Integer[result.size()];
        return  result.toArray(array);
    }

    public static Integer findMax(Integer[] nums){
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        Integer[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Integer[] result = findSlideWindowArrayMaxEle(nums, k);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
