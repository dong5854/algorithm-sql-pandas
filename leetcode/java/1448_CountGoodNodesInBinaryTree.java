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

    public int goodNodes(TreeNode root) {
        ans = 1;
        countGood(root, root.val);
        return ans;
    }

    private void countGood(TreeNode node, int pathMax) {
        if (node.left != null) {
            if (pathMax <= node.left.val) ans++;
            countGood(node.left, Math.max(pathMax, node.left.val));
        }

        if (node.right != null) {
            if (pathMax <= node.right.val) ans++;
            countGood(node.right, Math.max(pathMax, node.right.val));
        }
    }
}