package com.lien.algorithm.sort;

import com.lien.algorithm.sort.utils.SortUtil;

/**
 * Description: <br>
 *
 * @author li
 * @date 2019-12-24 14:55
 */
public class BubbleSort extends Sort {

    @Override
    void sort() {
        for(int i = 0; i < items.length; i++){
            for(int j = 0; j < items.length-i-1; j++){
                if(items[j] > items[j+1]){
                    SortUtil.swap(items, j, j+1);
                }
            }
        }
    }
}
