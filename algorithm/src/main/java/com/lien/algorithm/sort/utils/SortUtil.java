package com.lien.algorithm.sort.utils;

/**
 * Description: 判断是否排好序了 <br>
 *
 * @author li
 * @date 2018/8/24 下午3:02
 */
public class SortUtil {

    public static boolean isSort(Integer[] items){
        boolean isAscSorted = true;
        for(int i = 0; i < items.length - 1; i++){
            if(items[i] <= items[i+1]){
                continue;
            }else {
                isAscSorted =false;
                break;
            }
        }
        boolean isDescSorted = true;
        for(int i = 0; i < items.length - 1; i++){
            if(items[i] >= items[i+1]){
                continue;
            }else {
                isDescSorted =false;
                break;
            }
        }

        return isAscSorted || isDescSorted;
    }

    public static void main(String[] args){
        Integer[] items = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
        System.out.println(isSort(items));
    }

    public static void swap(Integer[] items, Integer source, Integer target){
        Integer temp = items[source];
        items[source] = items[target];
        items[target] = temp;
    }
}
