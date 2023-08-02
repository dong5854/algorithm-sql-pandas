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

    static final boolean LEFT = false;
    static final boolean RIGHT = true;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        int maxLength = Math.max(getZigZag(root, LEFT), getZigZag(root, RIGHT));

        return Math.max(maxLength, Math.max(longestZigZag(root.left), longestZigZag(root.right)));
    }

    private int getZigZag(TreeNode node, boolean dir) {
        int val = 0;
        while(node != null) {
            if (dir == LEFT) {
                node = node.left;
                dir = !dir;
                val++;
            } else {
                node = node.right;
                dir = !dir;
                val++;
            }
        }

        return val - 1;
    }
}