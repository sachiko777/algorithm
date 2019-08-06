package com.sort;

import java.util.Scanner;

//冒泡排序
public class BubbleSort {

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int [] array=new int [10];
        for (int i=0;i<array.length;i++){
            array[i]=scanner.nextInt();
        }

        System.out.println("排序前：");
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        array=bubbleSort(array);
        System.out.println("排序后：");
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }


    public static int[] bubbleSort(int[] array){
        if(array.length==0){
            return array;
        }
        for(int i=0;i<array.length;i++){
            for (int j=0;j<array.length-1-i;j++){
                if (array[j+1]<array[j]){//小到大
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }

}
