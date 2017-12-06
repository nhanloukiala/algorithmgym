package sorting;

/**
 * Created by nhan on 10/18/17.
 */
public class QuickSort {
    private static void quickSort(int[] arr){
        quickSort(arr, arr.length - 1, 0);
        return;
    }

    private static void quickSort(int[] arr, int hi, int lo){
        if(hi <= lo) return;
        int middle = (hi + lo) / 2;

        sortPartition(arr, hi, lo);
        quickSort(arr, hi, middle + 1);
        quickSort(arr, middle, lo);
    }

    private static void sortPartition(int[] arr, int hi, int lo){
        int pivot = hi;

        while(hi - 1 > lo) {
            if(arr[hi] < arr[pivot] && arr[lo] > arr[pivot]) {
                swap(arr, hi, lo);
                hi--;
                lo++;
            }

            if(arr[hi] >= arr[pivot]) hi--;
            if(arr[lo] < arr[pivot]) lo++;
        }

        if(arr[pivot] < arr[lo]) swap(arr, pivot, lo);
    }

    private static void swap(int arr[], int first, int second){
        int x = arr[first];
        arr[first] = arr[second];
        arr[second] = x;
    }

    public static void main(String[] args) {
           int[]  arr = {1,3, 10, 9, 7 ,5};

        quickSort(arr);
        for(int i: arr){
            System.out.println(i);
        }
    }
}
