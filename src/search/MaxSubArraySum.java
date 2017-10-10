package search;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by nhan on 9/24/17.
 */
public class MaxSubArraySum {
    static long maximumSum(long[] mem, long m) {
        for (int i = 0; i < mem.length; i++) {
            if (i == 0) {
                mem[i] %= m;
                continue;
            }

            mem[i] = (mem[i - 1] + mem[i] %m) % m;
        }

        TreeSet<Long> tree = new TreeSet<Long>();

        for(int i = 0; i < mem.length; i++) {
            max_sum = Math.max(mem[i],max_sum);
            if(max_sum == m - 1) return max_sum;
            SortedSet<Long> set = tree.tailSet(mem[i]);
            if(set.iterator().hasNext()){
                max_sum = Math.max(max_sum, (mem[i] - set.iterator().next() + m)%m);
            }

            tree.add(mem[i]);
//            insert(mem[i]);
        }

        return max_sum;
    }

    static class Node {
        public Node left;
        public Node right;
        public long value;

        public Node(long value) {
            Node.this.value = value;
        }
    }

    private static Node root;

    private static long max_sum = Long.MIN_VALUE;

    private static void insert(Node current, long value, long m) {
        if (current.value > value) {
            max_sum = Math.max(max_sum, value + m - current.value);
            if (current.left == null)
                current.left = new Node(value);
            else
                insert(current.left, value, m);
        } else if (current.value < value) {
            if (current.right == null)
                current.right = new Node(value);
            else insert(current.right, value, m);
        } else return;
    }

    private static void insert(long value, long m) {
        max_sum = Math.max(max_sum, value);
        if (root == null) root = new Node(value);
        else insert(root, value, m);
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
            root = null;
            System.out.println(result);
            max_sum = Long.MIN_VALUE;
        }
        in.close();
    }
}
