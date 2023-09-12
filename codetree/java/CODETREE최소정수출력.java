import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CODETREE최소정수출력 {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                Integer polled = pq.poll();
                if (polled == null) polled = 0;
                sb.append(polled).append("\n");
            } else {
                pq.add(num);
            }
        }

        System.out.println(sb);

        br.close();
    }
}