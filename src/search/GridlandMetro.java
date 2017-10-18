package search;

import java.util.Scanner;

/**
 * Created by ntrinh on 25/09/17.
 */
public class GridlandMetro {

    private static int solve(int[][] arr, int total) {
        int result = 0;

        // Maintain a dictionary with (row, min, max)
        int[][] dict = new int[arr.length][];

//        for(int i = 0;)

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] arr = new int[k][];
        for(int i = 0; i < k; i++){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            arr[i][2] = in.nextInt();
        }

    }
}
