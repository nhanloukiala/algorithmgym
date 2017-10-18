package search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhan on 10/17/17.
 */
public class CheckBST {
    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root){
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);

        for(int i = 1; i < list.size() - 1; i++){
            if(list.get(i) <= list.get(i-1))
                return false;
        }

        return true;
    }

    void inOrderTraversal(Node root, List<Integer> values){
        if(root == null) return;

        inOrderTraversal(root.left, values);
        values.add(root.data);
        inOrderTraversal(root.right, values);

    }
    public static void main(String[] args) {

    }
}
