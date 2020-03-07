package com.lien.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCode239 {

    public int[] method1(int[] data, int k){
        int[] result = new int[data.length - k + 1];
        for(int i = 0; i <= data.length - k ; i++){
            int biggest = data[i];
            for(int j = i + 1; j < i + k; j++){
                if(data[j] > biggest){
                    biggest = data[j];
                }
            }
            result[i] = biggest;
        }
        return result;
    }

    public int[] method2(int[] nums, int k){
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(deque.size() == 0){
                deque.add(i);
            }else {
                while (deque.size() > 0 && (i - deque.peek())>k-1){//移除超出区域的元素
                    deque.poll();
                }
                while (deque.size() > 0 && nums[deque.getLast()] < nums[i]){//入队
                    deque.removeLast();
                }
                deque.add(i);

            }
            if(i >= k-1 ){
                result[i - k +1 ] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] data = {2,3,4,2,6,2,5,1};
//        int[] data2 = {1,3,-1,-3,5,3,6,7};
//        int k = 3;
//        LeeCode239 leeCode239 = new LeeCode239();
//        int[] result1 = leeCode239.method1(data, k);
//        int[] result2 = leeCode239.method1(data2, k);
//        int[] result3 = leeCode239.method2(data, k);
//        int[] result4 = leeCode239.method2(data2, k);
//        printData(data);
//        printData(result1);
//        printData(result3);
//        System.out.println("");
//        printData(data2);
//        printData(result2);
//        printData(result4);

        int[] data = {1,-1};
        int k = 1;
        LeeCode239 leeCode239 = new LeeCode239();
        int[] result = leeCode239.method2(data, k);
        printData(result);

    }

    public static void printData(int[] data){
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }

}
