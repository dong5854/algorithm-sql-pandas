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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        createLeafList(root1, list1);
        createLeafList(root2, list2);

        return list1.equals(list2);
    }

    private void createLeafList(TreeNode node, List<Integer> list) {
            if (node.left == null && node.right == null) {
                list.add(node.val);
                return;
            }
            if (node.left != null) {
                createLeafList(node.left, list);
            }
            if (node.right != null)  {
                createLeafList(node.right, list);
            }
    }
}