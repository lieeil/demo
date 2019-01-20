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
        //建堆
        for(int i = items.length - 1; i >= 0; i--){
            shiftDown(i, items.length -1);
        }
        swap(0,items.length - 1);
        for(int i = items.length - 2; i >= 0; i--){
            shiftDown(0, i);
            swap(0,i);
        }
    }



    /**
     * 节点下移操作
     * @param parentIndex 下移操作的根下标
     * @param lastIndex 最后元素的下标
     */
    private void shiftDown(int parentIndex, int lastIndex){
        while(parentIndex <= lastIndex && 2*parentIndex + 1 <= lastIndex){
            int leftSonIndex = 2*parentIndex + 1;
            int rightSonIndex = 2*parentIndex + 2;
            int targetIndex = -1;
            if(rightSonIndex <= lastIndex){
                if(items[parentIndex] < items[leftSonIndex] || items[parentIndex] < items[rightSonIndex]){
                    if(items[leftSonIndex] > items[rightSonIndex]){
                        targetIndex = leftSonIndex;
                    }else{
                        targetIndex = rightSonIndex;
                    }
                }
            }else {
                if(items[parentIndex] < items[leftSonIndex]){
                    targetIndex = leftSonIndex;
                }
            }
            if(targetIndex != -1){
                swap(parentIndex, targetIndex);
                parentIndex = targetIndex;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args){
        HeapSort sort = new HeapSort();
        Integer[] items = {99,3009,45,34985,12,45,67,1,234,56,8890,7864};
        Integer[] items2 = {20,50,20,40,70,10,80,30,60};
        sort.setItems(items);
        sort.sort();
        sort.printItems();
        System.out.println();
        sort.setItems(items2);
        sort.sort();
        sort.printItems();
    }

}
