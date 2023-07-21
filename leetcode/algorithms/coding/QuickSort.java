package leetcode.algorithms.coding;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public int[] quickSort(int[] arr,int low,int high){

        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);

            quickSort(arr, pivot + 1, high);
        }
        return arr;

    }


    public int partition(int[] arr, int low, int high){
        int tmp = arr[low];

        while(low < high){
            while (low < high && arr[high] >= tmp) high--;
            arr[low] = arr[high];

            while (low < high && arr[low] <= tmp) low++;
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,0,10,9,8,5,7,12,89};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr,0,arr.length-1);
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);

        }

        System.out.println(list);
    }
}
