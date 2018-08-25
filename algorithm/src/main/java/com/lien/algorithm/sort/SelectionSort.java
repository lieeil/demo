package com.lien.algorithm.sort;

/**
 * Description: <br>
 *
 * @author li
 * @date 2018/8/24 下午4:01
 */
public class SelectionSort extends Sort {


    void sort() {
        for(int i = 0; i < items.length - 1; i++){
            Integer tempIndex = i;
            for(int j = i + 1; j < items.length; j++){
                if(items[j] < items[tempIndex]){
                    tempIndex = j;
                }
            }
            swap(i,tempIndex);
        }
    }
}
