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

    public int pathSum(TreeNode root, int targetSum) {
        if (root ==null) return 0;

        return getSum(root, targetSum, 0) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int getSum(TreeNode node, int targetSum, long sum) {
        int ret = 0;
        if (node == null) return ret;

        sum += node.val;

        if (sum == targetSum) ret++;

        ret += getSum(node.left, targetSum, sum);
        ret += getSum(node.right, targetSum, sum);

        return ret;
    }
}