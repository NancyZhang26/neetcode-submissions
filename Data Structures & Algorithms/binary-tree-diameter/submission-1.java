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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        height(root, max);
        return max[0];
    }
    public int height(TreeNode root, int[] max) {
        if (root==null) return -1;
        int left = height(root.left, max)+1;
        int right = height(root.right, max)+1;
        max[0] = Math.max(max[0], left+right);
        return Math.max(left, right);
    }
}
