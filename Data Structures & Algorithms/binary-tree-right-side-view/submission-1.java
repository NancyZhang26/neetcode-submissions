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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null) return list;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        list.add(root.val);

        while (!q.isEmpty()) {
            int size = q.size();
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left!=null) {
                    q.offer(node.left);
                    s.push(node.left.val);
                }
                if (node.right!=null) {
                    q.offer(node.right);
                    s.push(node.right.val);
                }
            }
            if (s.size()>0) list.add(s.pop());
        }

        return list;
    }
}
