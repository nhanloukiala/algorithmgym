package implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nhan on 11/5/17.
 */
public class Equal {
    private static int solve(int[] arr){
        int result = 0;

        Arrays.sort(arr);
        int min = arr[0];

        for( int i = 0; i < arr.length; i++) {
            while(arr[i] != min) {
                result++;
                if(arr[i] - min >= 5) arr[i] -= 5;
                else if(arr[i] - min >= 2) arr[i] -= 2;
                else if (arr[i] - min >= 1) arr[i] -= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();

        for(int i = 0; i < cases; i++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int j  = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }

            System.out.println(solve(arr));
        }
    }
}
