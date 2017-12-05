package sorting;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by nhan on 10/21/17.
 */
public class InsertionSortAdvanceAnalysis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int[] arr = new int[n];

            long sum = 0;
            TreeSet<Integer> tree = new TreeSet<Integer>();

            for(int j = 0; j < n; j++){
                arr[j] = in.nextInt();
                tree.add(arr[j]);
                int diff = tree.tailSet(arr[j], false).size();

                sum += diff > 0 ? diff : 0;
            }

            System.out.println(sum);
        }
    }
}
