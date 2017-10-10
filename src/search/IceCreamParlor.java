package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nhan on 10/5/17.
 */
public class IceCreamParlor {
    public static void solve(int m, int[] arr){
        int low = 0;
        int high = arr.length - 1;
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);

        while(high > low) {
            int sum = arr[low] + arr[high];
            if(sum == m) {
                int originalLow = getIndex(arr[low], arrCopy);
                int originalHigh = getReverseIndex(arr[high], arrCopy);
                originalLow++;
                originalHigh++;
                System.out.println(Math.min(originalLow, originalHigh) + " " + Math.max(originalHigh, originalLow));
                return;
            } else if (sum > m) {
                high--;
            } else low++;
        }
    }

    private static int getIndex(int value, int arr[]){
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == value) return i;
        }

        return -1;
    }

    private static int getReverseIndex(int value, int arr[]){
        for(int i = arr.length - 1 ; i >=0; i--){
            if(arr[i] == value) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for(int i = 0; i < t; i++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];

            for(int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            solve(m, arr);
        }
    }
}
