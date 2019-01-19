package com.lien.algorithm.sort;

/**
 * Description: 堆排序<br>
 *
 * @author li
 * @date 2019-01-18 17:27
 */
public class HeapSort extends Sort {


    @Override
    void sort() {
        for(int i = items.length -1; i >= 0; i--){
            headSort(i);
        }
    }

    private void headSort(int length){
        for(int i = length; i >= 0; i--){
            int noLeafIndex = (i-1)/2;
            int leftIndex = noLeafIndex*2 + 1;
            int rightIndex = noLeafIndex*2 + 2;
            if(items[noLeafIndex] < items[rightIndex] && items[noLeafIndex] < items[leftIndex]){
                swap(noLeafIndex, items[leftIndex] < items[rightIndex] ? items[rightIndex]:items[leftIndex]);
            }
        }
    }
}
