package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ntrinh on 24/09/17.
 */
public class HackerLand {
    private static int solve(int[] arr, int k){
        Arrays.sort(arr);

        int left = 0;
        int result = 0;
        int i = 0;

        while( i < arr.length) {
            result++;
            while(i < arr.length && arr[i] - arr[left] <= k) i++;
            int central = i - 1;
            while((i < arr.length) && (arr[i] - arr[central] <= k)) i++;
            left = i;
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }

        System.out.println(solve(x, k));
    }
}
