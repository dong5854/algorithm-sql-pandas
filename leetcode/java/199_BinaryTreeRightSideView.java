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
      List<Integer> ans = new ArrayList<>();
      rightNodes(root, ans, 0);
      return ans;
  }

  private void rightNodes(TreeNode node, List<Integer> list ,int cnt) {
      if (node == null) return;
      if (list.size() <= cnt) list.add(node.val);
      if (node.right != null) rightNodes(node.right, list, cnt + 1);
      if (node.left != null) rightNodes(node.left, list, cnt + 1);
  }
}