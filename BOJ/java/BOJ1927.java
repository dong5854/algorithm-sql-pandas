import java.io.*;
import java.util.*;

public class BOJ1927 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0 && pq.isEmpty()) sb.append(0).append("\n");
            else if (num == 0) {
                sb.append(pq.poll()).append("\n");
            } else {
                pq.add(num);
            }
        }
        System.out.println(sb);
    }
}
