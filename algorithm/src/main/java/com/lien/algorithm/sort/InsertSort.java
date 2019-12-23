package com.lien.algorithm.sort;

import com.lien.algorithm.sort.utils.SortUtil;

/**
 * Description: <br>
 *
 * @author li
 * @date 2019-12-23 17:24
 */
public class InsertSort extends Sort {

    @Override
    void sort() {
        for(int i = 1; i < this.items.length; i++){
            for(int j = i; j > 0; j--){
                if(items[j] < items[j-1]){
                    SortUtil.swap(items, j, j-1);
                }else {
                    break;
                }
            }
        }
    }
}
