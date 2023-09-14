import java.io.*;
import java.util.*;

public class CODETREE배열추출2 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int c = Integer.compare(a[0], b[0]);
            if (c == 0) c = Integer.compare(a[1], b[1]);
            return c;
        });
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                int[] polled = pq.poll();
                if (polled == null) sb.append(0);
                else sb.append(polled[0] * polled[1]);
                sb.append("\n");
            } else if (num < 0) {
                pq.add(new int[]{-num, -1});
            } else {
                pq.add(new int[]{num, 1});
            }
        }

        System.out.println(sb);
        
        br.close();
    }
}