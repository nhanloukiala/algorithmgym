package search;

import java.util.Scanner;

/**
 * Created by nhan on 10/6/17.
 */
public class MinimumLoss {
    static class Node {
        public Node left;
        public Node right;
        public long value;

        public Node(long value) {
            Node.this.value = value;
        }
    }

    private static Node root;

    private static long min_loss = Long.MIN_VALUE;

    private static void insert(Node current, long value) {
        if (current.value > value) {
            min_loss = Math.max(min_loss, value - current.value);
            if (current.left == null)
                current.left = new Node(value);
            else
                insert(current.left, value);
        } else if (current.value <= value) {
            if (current.right == null)
                current.right = new Node(value);
            else insert(current.right, value);
        }
    }

    private static void insert(long value) {
        if (root == null) root = new Node(value);
        else insert(root, value);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long arr[] = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextLong();
        }

        for (int j = 0; j < arr.length; j++) {
            insert(arr[j]);
        }
        min_loss = min_loss == Long.MIN_VALUE ? 0 : min_loss;
        System.out.println(Math.abs(min_loss));
    }
}
