package search;

import java.util.Scanner;

/**
 * Created by nhan on 10/7/17.
 */
public class MissingNumbers {
    private static void solve(int[] arrn, int[] arrm){
        int[] mem = new int[100];

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arrm.length; i++){
            min = Math.min(min, arrm[i]);
        }

        for(int i  = 0; i < arrm.length; i++){
            if(i < arrn.length) mem[arrn[i] - min]--;
            mem[arrm[i] - min]++;
        }

        for(int i = 0; i < mem.length; i++){
            if(mem[i] != 0) System.out.print((i + min) + " ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arrn = new int[n];
        for(int i  = 0 ; i < n; i++){
            arrn[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] arrm = new int[m];
        for(int i  = 0 ; i < m; i++){
            arrm[i] = in.nextInt();
        }

        solve(arrn, arrm);
    }
}
