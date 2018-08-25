package com.lien.algorithm.sort;

import com.lien.algorithm.sort.utils.SortUtil;

/**
 * Description: <br>
 *
 * @author li
 * @date 2018/8/24 下午4:01
 */
public abstract class Sort {

    protected Integer[] items;

    protected void swap(Integer sourceIndex, Integer targetIndex){
        SortUtil.swap(items, sourceIndex, targetIndex);
    }

    abstract void sort();

    public Integer[] getItems() {
        return items;
    }

    public void setItems(Integer[] items) {
        this.items = items;
    }

    public void printItems(){
        for(int i = 0; i < items.length; i++){
            System.out.print(items[i] + " ");
        }
    }
}
