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
        if (root == null) {
            return false;
        }
        if (subRoot == null) {
            return true;
        }

        return isSametree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSametree(TreeNode n1, TreeNode n2) {
        if (n1==null && n2==null) {
            return true;
        } else if (n1==null | n2==null) {
            return false;
        } else if (n1.val != n2.val) {
            return false;
        }

        return isSametree(n1.left, n2.left) && isSametree(n1.right, n2.right);
    }
}
