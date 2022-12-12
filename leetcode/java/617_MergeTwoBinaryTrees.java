// https://leetcode.com/problems/merge-two-binary-trees/?envType=study-plan&id=algorithm-i
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
// /*
//  * Stack을 활용한 풀이
//  */
// class Solution {
//     public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//         if (t1 == null) return t2;
//         Stack<TreeNode[]>stack = new Stack<>();
//         stack.push(new TreeNode[]{t1, t2});
//         while (!stack.empty()) {
//             TreeNode[] node = stack.pop();
//             if (node[0] == null || node[1] == null) continue;
//             node[0].val += node[1].val;
//             if (node[0].left == null) {
//                 node[0].left = node[1].left;
//             } else {
//                 stack.push(new TreeNode[]{node[0].left, node[1].left});
//             }
//             if (node[0].right == null) {
//                 node[0].right = node[1].right;
//             } else {
//                 stack.push(new TreeNode[]{node[0].right, node[1].right});
//             }
//         }
//         return t1;
//     }
// }