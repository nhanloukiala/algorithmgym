package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nhan on 10/7/17.
 */
public class Pairs {
    static int pairs(int[] arr,int k) {
      /* Complete this function */
        Arrays.sort(arr);

        if(k > arr[arr.length - 1]) return 0;

        int count = 0;

        for(int i = 0; i < arr.length - 1; i++){
            if(binarySearch(arr, i + 1, arr.length - 1, arr[i] + k)) count++;
            if(binarySearch(arr, i + 1, arr.length - 1, arr[i] - k)) count++;
        }
        return count;
    }

    static boolean binarySearch(int[] arr, int lo, int hi, int val){
        while(hi >= lo){
            int mid = (hi + lo) / 2;
            if(arr[mid] == val) return true;
            else if (arr[mid] > val) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String n = in.nextLine();
        String[] n_split = n.split(" ");

        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);

        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = pairs(_a,_k);
        System.out.println(res);
    }
}
