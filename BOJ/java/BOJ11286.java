import java.util.*;
import java.io.*;

public class BOJ11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int c = Integer.compare(o1[1], o2[1]);
                if (c==-0) c = Integer.compare(o1[0], o2[0]);
                return c;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0 && pq.isEmpty()) sb.append(0).append("\n");
            else if (num == 0) sb.append(pq.poll()[0]).append("\n");
            else {
                pq.add(new int[]{num, Math.abs(num)});
            }
        }
        System.out.println(sb);
    }
}
