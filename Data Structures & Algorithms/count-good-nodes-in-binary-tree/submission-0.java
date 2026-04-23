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
    
    int count = 0;

    public int goodNodes(TreeNode root) {
        countNodes(root, Integer.MIN_VALUE);
        return count;
    }

    public void countNodes(TreeNode root, int min) {
        if (root==null) return;

        if (root.val>=min) {
            min = root.val;
            count++;
        }
        countNodes(root.left, min);
        countNodes(root.right, min);
    }
}
