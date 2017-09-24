package search;

import scala.Array;

import java.util.Scanner;

/**
 * Created by nhan on 9/24/17.
 */
public class MaxSubArraySum {
    static long maximumSum(long[] mem, long m) {
        // Complete this function

        long result = 0;


        for (int i = 0; i < mem.length; i++) {
            if (i == 0) {
                mem[i] %= m;
                continue;
            }

            mem[i] = (mem[i - 1] + mem[i] %m) % m;
        }

        for(int i = 0; i < mem.length; i++) {
                result = Math.max(result, mem[i]);
        }

        for(int i = 0; i < mem.length; i++) {
            for(int j = i + 1; j < mem.length; j++) {
                long gap = (mem[j] - mem[i] + m ) % m;
                result = Math.max(gap, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            long m = in.nextLong();
            long[] a = new long[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextLong();
            }
            long result = maximumSum(a, m);
            System.out.println(result);
        }
        in.close();
    }
}
