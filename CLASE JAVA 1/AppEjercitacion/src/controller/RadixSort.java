package controller;

import java.util.Arrays;

public class RadixSort {

    public static void redixSort(int []arr) {
        String strArray[] = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArray[i] = String.valueOf(arr[i]);
        }
        System.out.println(Arrays.toString(strArray));
    }


    public static void main(String[] args) {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        //radixSort(arr);

        for(int i:arr){
            System.out.println(i);
        }
    }
}
