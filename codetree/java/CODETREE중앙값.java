import java.io.*;
import java.util.*;

public class CODETREE중앙값 {
    
    static int t;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();
            m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 첫번째 숫자
            int mid = Integer.parseInt(st.nextToken());
            sb.append(mid).append(" ");

            
            for (int i = 2; i <= m; i++) {
                int num = Integer.parseInt(st.nextToken());

                if (num < mid) {
                    left.add(num);
                } else {
                    right.add(num);
                }

                if (i % 2 == 1) {
                    if (left.size() > right.size()) {
                        right.add(mid);
                        mid = left.poll();
                    } else if (left.size() < right.size()) {
                        left.add(mid);
                        mid = right.poll();
                    }
                    sb.append(mid).append(" ");
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}