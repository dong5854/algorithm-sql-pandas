import java.io.*;
import java.util.*;

public class BOJ1991 {
    static int N;

    static Map<Character, Node> map;

    static StringBuilder sb;
    static public class Node {
        char val;
        Node leftChild;
        Node rightChild;

        public Node(char val) {
            this.val = val;
            map.put(val, this);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        // 트리 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Node rootNode, leftNode, rightNode;

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            // root
            if (map.containsKey(root)) {
                rootNode = map.get(root);
            } else {
                rootNode = new Node(root);
            }

            // leftChild
            if (map.containsKey(left)) {
                leftNode = map.get(left);
            } else {
                leftNode = new Node(left);
            }
            rootNode.leftChild = leftNode;

            // rightChild
            if (map.containsKey(right)) {
                rightNode = map.get(right);
            } else {
                rightNode = new Node(right);
            }
            rootNode.rightChild = rightNode;
        }

        preOrder(map.get('A'));
        sb.append("\n");
        inOrder(map.get('A'));
        sb.append("\n");
        postOrder(map.get('A'));

        System.out.println(sb);
        br.close();
    }

    static void preOrder(Node node) {
        if (node.val == '.') {
            return;
        }
        sb.append(node.val);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    static void inOrder(Node node) {
        if (node.val == '.') {
            return;
        }

        inOrder(node.leftChild);
        sb.append(node.val);
        inOrder(node.rightChild);
    }

    static void postOrder(Node node) {
        if (node.val == '.') {
            return;
        }

        postOrder(node.leftChild);
        postOrder(node.rightChild);
        sb.append(node.val);
    }
}
