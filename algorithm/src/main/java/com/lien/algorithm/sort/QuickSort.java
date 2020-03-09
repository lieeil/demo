package com.lien.algorithm.sort;


/**
 * 快排思想
 */
public class QuickSort extends Sort {


    @Override
    void sort() {
        int length = this.items.length;
        quickSort(0,length-1);
    }

    private void quickSort(int start, int end){
        if(start >= end){
            return;
        }
        int low = start;
        int high = end;
        int mediumSize = this.items[low];
        while (low < high){
            while (low < high && items[high] >= mediumSize){
                high--;
            }
            swap(low,high);
            while (low < high && items[low] <= mediumSize){
                low++;
            }
            swap(low, high);
        }
        items[low] = mediumSize;
        quickSort(start, low-1 );
        quickSort(low+1, end);
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        Integer[] items = {99,3009,45,34985,12,45,67,1,234,56,8890,7864};
        sort.setItems(items);
        sort.printItems();
        sort.sort();
        System.out.println("");
        sort.printItems();
    }
}
