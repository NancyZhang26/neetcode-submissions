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
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }
    public int height(TreeNode root) {
        if (root==null) return -1;
        int left = height(root.left)+1;
        int right = height(root.right)+1;
        max = Math.max(max, left+right);
        return Math.max(left, right);
    }
}
