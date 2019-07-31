package com.lien.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/two-sum/description/<br>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * @author li
 * @date 2019-05-22 12:20
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target){
        int[] result = null;
        if(nums == null || nums.length == 0){
            return result;
        }
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            numMap.put(nums[i], i);
        }
        for(int i = 0; i < nums.length ; i++){
            int target2 = target - nums[i];
            if(numMap.containsKey(target2) && numMap.get(target2) != i ){
                result = new int[2];
                result[0] = i;
                result[1] = numMap.get(target2);
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args){
       int[] nums = {3,2,4};
       int target = 6;
       int[] result = twoSum(nums, target);
       if(result != null){
           System.out.println(result[0] + "  " + result[1]);
       }
    }


}
