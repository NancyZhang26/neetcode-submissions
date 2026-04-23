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
    int max;
    public int maxDepth(TreeNode root) {
        max(root);
        return max;
    }

    public int max(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = max(node.left)+1;
        int right = max(node.right)+1;
        max = Math.max(max, Math.max(left, right));
        return Math.max(left, right);
    }
}
