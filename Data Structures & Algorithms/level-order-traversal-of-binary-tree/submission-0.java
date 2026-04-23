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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        res.add(Arrays.asList(root.val));

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    l.add(node.left.val);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    l.add(node.right.val);
                    q.offer(node.right);
                }
            }
            if (l.size()>0) res.add(l);
        }

        return res;
    }
}
