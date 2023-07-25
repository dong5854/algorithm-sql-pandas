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

    static TreeNode ans;
    public TreeNode searchBST(TreeNode root, int val) {
        ans = null;
        search(root, val);
        return ans;
    }

    public void search(TreeNode node, int val) {
        if (node.val == val) {
            ans = node;
            return;
        }

        if (node.left != null) search(node.left, val);
        if (node.right != null) search(node.right, val);
    }
}