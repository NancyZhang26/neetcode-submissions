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
    public int kthSmallest(TreeNode root, int k) {
        int[] t = new int[2];
        t[0] = k;
        smallest(root, t);
        return t[1];
    }

    public void smallest(TreeNode root, int[] temp) {
        if (root==null) return;

        smallest(root.left, temp);
        temp[0]--;
        if (temp[0]==0) {
            temp[1] = root.val;
            return;
        }
        smallest(root.right, temp);
    }
}
