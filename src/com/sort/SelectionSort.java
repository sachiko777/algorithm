package com.sort;

//选择排序
public class SelectionSort {

    public static void main(String args[]){

    }

    public int[] selectionSort(int[] array){
        if (array.length==0){
            return array;
        }
        for (int i=0;i<array.length;i++){
            int min=i;
            for(int j=i;j<array.length;j++){
                if (array[j]<array[min]){//找最小
                    min=j;
                }
                int temp=array[min];
                array[min]=array[i];
                array[i]=temp;
            }
        }
        return array;
    }


}
