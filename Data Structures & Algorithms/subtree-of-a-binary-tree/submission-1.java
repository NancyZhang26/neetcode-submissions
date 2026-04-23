/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root, subRoot)) return true;

        boolean left = root!=null?isSubtree(root.left, subRoot):false;
        boolean right = root!=null?isSubtree(root.right, subRoot):false;

        return left || right;
    }

    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1==null && node2==null) return true;
        if (node1==null || node2==null || node1.val!=node2.val) return false;

        return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }
}
