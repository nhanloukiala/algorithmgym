package dp;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by ntrinh on 13/10/17.
 */
public class LIS {
    private static class Subsequence implements Comparable<Subsequence> {
        public int length;
        public int hiVal;

        public Subsequence(int hiVal){
            Subsequence.this.length = 1;
            Subsequence.this.hiVal = hiVal;
        }

        @Override
        public boolean equals(Object obj) {
            return Subsequence.this.length == ((Subsequence)obj).length
                    && Subsequence.this.hiVal == ((Subsequence)obj).hiVal;
        }

        @Override
        public int compareTo(Subsequence o) {
            if(Subsequence.this.hiVal == o.hiVal) {
                return Subsequence.this.length - o.length;
            } else return Subsequence.this.hiVal - o.hiVal;
        }
    }

    private static int solve(int[] arr) {
        int result;
        TreeSet<Subsequence> treeSet = new TreeSet<>();
        Subsequence min = new Subsequence(Integer.MIN_VALUE);
        min.length = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            Subsequence current = new Subsequence(arr[i]);
            Iterator<Subsequence> it = treeSet.headSet(current).iterator();
            if(!it.hasNext()) {
                treeSet.add(current);
            } else {
                while(it.hasNext()){
                    Subsequence next = it.next();
                    next.hiVal = current.hiVal;
                    next.length += 1;
                }
            }
        }

        result = treeSet.descendingIterator().next().length;

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solve(arr));
    }
}
