package graph;
import java.util.*;

public class ValidateBinarySearchTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> result = new ArrayList();
        traverse(root, result);

        for(int i = 0; i < result.size(); i++) {
            if(!(i == 0 || result.get(i) > result.get(i-1))) return false;
        }

        return true;
    }

    public void traverse(TreeNode current, List<Integer> vals) {
        if(current == null) return;

        traverse(current.left, vals);
        vals.add(current.val);
        traverse(current.right, vals);
    }
}
