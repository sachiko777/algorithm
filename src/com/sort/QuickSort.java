package com.sort;

//快速排序
public class QuickSort {

    public static void main(String args[]){

    }

    public static int[] quickSort(int[] array,int start,int end){
        if (array.length<1|| start<0||end>=array.length||start>end){
            return null;
        }
        int smallIndex=partition(array,start,end);
        if (smallIndex>start)
            quickSort(array,start,smallIndex-1);
        if (smallIndex<end)
            quickSort(array,smallIndex+1,end);
        return array;
    }

    public static int partition(int[] array, int start,int end){
        int pivot=(int)(start+Math.random()*(end-start+1));
        int smallIndex=start-1;
        swap(array,pivot,end);
        for (int i=start;i<=end;i++){
            if (array[i]<array[end]){
                smallIndex++;
                if (i>smallIndex){
                    swap(array,i,smallIndex);
                }
            }
        }
        return smallIndex;
    }


    /**
     * 交换i和j
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }


}
