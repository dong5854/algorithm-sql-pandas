import java.io.*;
import java.util.*;

public class CODETREE최솟값3개 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        long[] list = Arrays.stream(br.readLine().split(" ")).
        mapToLong(Long::parseLong).
        toArray();

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (long num : list) {
            pq.add(num);

            while (pq.size()> 3) {
                pq.poll();
            }

            if (pq.size() < 3) {
                sb.append("-1\n");
            } else {
                long a = pq.poll();
                long b = pq.poll();
                long c = pq.poll();
                sb.append(a * b * c).append("\n");
                pq.add(a);
                pq.add(b);
                pq.add(c);
            }
        }

        System.out.println(sb);

        br.close();
    }
}