// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/?envType=study-plan&id=algorithm-i
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        setNext(root.left, root.right);
        return root;
    }
    public void setNext(Node node1, Node node2) {
        if (node1 == null) return;
        node1.next = node2;
        setNext(node1.left, node1.right);
        setNext(node1.right, node2.left);
        setNext(node2.left, node2.right);
    }
}