import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CODETREE큰숫자만계속고르기 {

    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = Arrays.stream(br.readLine().split(" ")).
        map(i -> (-Integer.parseInt(i))).
        collect(Collectors.toCollection(PriorityQueue::new));

        for (int i = 0; i < m; i++) {
            int num = pq.poll();
            pq.add(num+1);
        }

        System.out.println(-pq.peek());

        br.close();
    }
}