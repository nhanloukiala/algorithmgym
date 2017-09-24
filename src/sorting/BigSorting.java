package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by nhan on 9/23/17.
 */
public class BigSorting {
    private static String[] sort(String[] arr){
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                else return o1.length() - o2.length();
            }
        });

        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }

        String[] sorted = sort(unsorted);
        for(int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
        // your code goes here
    }
}
