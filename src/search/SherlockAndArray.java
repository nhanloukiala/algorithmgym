package search;

import java.util.Scanner;

/**
 * Created by ntrinh on 26/10/17.
 */
public class SherlockAndArray {
    static String solve(int[] a){

        if(a.length == 2) return "NO";
        if(a.length == 1) return "YES";
        // Complete this function
        int[] sum = new int[a.length];
        sum[0] = a[0];
        for(int i = 1; i < a.length; i++) {
            sum[i] = sum[i-1] + a[i];
        }

        for(int i = 1; i < a.length; i++) {
            if(sum[i-1] * 2 == sum[sum.length - 1] - a[i])
                return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}
