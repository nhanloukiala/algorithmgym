package graph;

public class ClosestBinarySearchTreeValue {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    public int closestValue(TreeNode root, double target) {
        return (int)traverse(root, target, Double.MAX_VALUE, null);
    }

    public long traverse(TreeNode current, double target, double prevDelta, TreeNode prev) {
        if(current == null) return Long.MAX_VALUE;
        double currentDelta = Math.abs(current.val - target);

        long leftVal = traverse(current.left, target, currentDelta, current);
        long rightVal = traverse(current.right, target, currentDelta, current);
        double left = Math.abs(leftVal - target);
        double right = Math.abs(rightVal - target);

        if(right <= left && right <= currentDelta) {
            return rightVal;
        } else if (left <= right && left <= currentDelta) {
            return leftVal;
        } else
            return current.val;
    }
}
