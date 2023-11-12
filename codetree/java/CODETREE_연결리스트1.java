import java.io.*;
import java.util.*;

public class CODETREE_연결리스트1 {

    static class Node {
        String val;
        Node prev, next;

        public Node(String val) {
            this.val = val;
        }

        public String getVal() {
            return val + " ";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sVal = br.readLine();
        Node cur = new Node(sVal);

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int val = Integer.parseInt(st.nextToken());
            String str = null;
            if (st.hasMoreTokens()) str = st.nextToken();

            if (val == 1) {
                Node temp = new Node(str);
                if (cur.prev != null) cur.prev.next = temp;
                temp.prev = cur.prev;
                cur.prev = temp;
                temp.next = cur;
            } else if (val == 2) {
                Node temp = new Node(str);
                if (cur.next != null) cur.next.prev = temp;
                temp.next = cur.next;
                cur.next = temp;
                temp.prev = cur;
            } else if (val == 3 && cur.prev != null) {
                cur = cur.prev;
            } else if (val == 4 && cur.next != null) {
                cur = cur.next;
            }
            
            if (cur.prev != null) sb.append(cur.prev.getVal());
            else sb.append("(Null) ");
            sb.append(cur.getVal());
            if (cur.next != null) sb.append(cur.next.getVal());
            else sb.append("(Null) ");
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}