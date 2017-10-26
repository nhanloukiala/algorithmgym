package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nhan on 10/16/17.
 */
public class StockMaximize {
    private static long solve(int[] arr){
        long result = 0;
        int currentMax = 0;
        for(int i = arr.length - 1; i > -1; i--){
            if(arr[i] > currentMax){
                currentMax = arr[i];
            }

            int profit = currentMax - arr[i];
            result += profit;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(solve(arr));
        }
        in.close();
    }
}
