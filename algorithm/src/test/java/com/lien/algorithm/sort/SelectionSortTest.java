package com.lien.algorithm.sort;


import org.junit.Test;

/**
 * Created by lienquan on 2018/8/24.
 */
public class SelectionSortTest {

    @Test
    public void sort() {
        SelectionSort selectionSort = new SelectionSort();
        Integer[] items = {3339,499,908,2,456,7,543,-19,0,0,345};
        selectionSort.setItems(items);
        selectionSort.sort();
        selectionSort.printItems();
        System.out.println();
        InsertSort insertSort = new InsertSort();
        Integer[] items2 = {3339,499,908,2,456,7,543,-19,0,0,345};
        insertSort.setItems(items2);
        insertSort.sort();
        insertSort.printItems();

        System.out.println();
        Sort bubbleSort = new BubbleSort();
        Integer[] items3 = {3339,499,908,2,456,7,543,-19,0,0,345};
        bubbleSort.setItems(items3);
        bubbleSort.sort();
        bubbleSort.printItems();
    }

}