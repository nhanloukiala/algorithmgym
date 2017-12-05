package search;

import java.util.Scanner;

/**
 * Created by ntrinh on 27/11/17.
 */
public class Trie {
    public static class TrieNode{
        public int value;
        public TrieNode[] children;

        public TrieNode(){
            this.value = 0;
            this.children = new TrieNode[26];
        }

        public TrieNode(int value){
            this.value = value;
            this.children = new TrieNode[26];
        }
    }

    private static TrieNode root;

    private static void insert(String word){
        char[] arr = word.toCharArray();
        TrieNode current = root;

        for(int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';

            if(current.children[index] == null) {
                current.children[index] = new TrieNode(1);
            } else {
                current.children[index].value++;
            }

            current = current.children[index];
        }
    }

    private static int query(String word){
        char[] arr = word.toCharArray();

        TrieNode current = root;

        for(int i = 0; i < arr.length; i++){
            if(current.children[arr[i] - 'a'] == null) return 0;
            else current = current.children[arr[i] - 'a'];
        }

        return current.value;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        root = new TrieNode();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            if(op.equals("add")) {
                insert(contact);
            } else {
                System.out.println(query(contact));
            }
        }


    }
}
