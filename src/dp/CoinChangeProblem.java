package dp;

import java.util.*;

/**
 * Created by ntrinh on 15/10/17.
 */
public class CoinChangeProblem {
    private static long solve(int[] arr, int n) {
        Arrays.sort(arr);
        long[][] cache = new long[arr.length + 1][n + 1];

        for(int i = 0; i < cache.length; i++) cache[i][0] = 1;
        for(int i = 0; i < cache[0].length; i++) cache[0][i] = 0;

        for(int i = 1; i < cache[0].length; i++) {
            for(int j = 1; j < cache.length; j++) {
                long prev = ((i - arr[j - 1] >= 0) ? cache[j][i - arr[j - 1]] : 0);
                cache[j][i] = cache[j-1][i] + prev;
            }
        }

        return cache[arr.length][n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[m];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solve(arr, n));
    }
}
