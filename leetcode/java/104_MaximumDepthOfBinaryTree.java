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

    static int ans;

    public int maxDepth(TreeNode root) {
        ans = 0;
        search(root, 1);
        return ans;
    }

    public void search(TreeNode node, int depth) {
        if (node == null) return;
        ans = Math.max(ans, depth);
        search(node.left, depth+1);
        search(node.right, depth+1);
        return;
    }
}