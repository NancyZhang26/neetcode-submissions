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
    ArrayList<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        addNode(root);
        Collections.sort(list);
        return list.get(k-1);
    }

    public void addNode(TreeNode root) {
        if (root==null) return;

        addNode(root.left);
        addNode(root.right);

        list.add(root.val);
    }
}
