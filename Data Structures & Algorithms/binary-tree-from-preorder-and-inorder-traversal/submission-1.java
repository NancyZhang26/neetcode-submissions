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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = helper(preorder, inorder, 0, 0, inorder.length-1);
        return node;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart == preorder.length || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        
        int index = indexOf(inorder, inStart, inEnd, preorder[preStart]);
        int size = index - inStart + 1;

        root.left = helper(preorder, inorder, preStart+1, inStart, index-1);
        root.right = helper(preorder, inorder, preStart+size, index+1, inEnd);

        return root;
    }

    public int indexOf(int[] inorder, int inStart, int inEnd, int target) {
        while (inStart <= inEnd) {
            if (inorder[inStart] == target) return inStart;
            inStart++;
        }
        return -1;
    }
}
