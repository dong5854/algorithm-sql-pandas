import java.io.*;
import java.util.*;

public class CODETREE_컴퓨터이용기간 {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<int[]> users = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> computer = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            pq.add(i);
            users.add(new int[]{Integer.parseInt(st.nextToken()), i});
            users.add(new int[]{Integer.parseInt(st.nextToken()), i});
        }

        int[] ans = new int[n+1];
        while(!users.isEmpty()) {
            int[] valID = users.poll();
            int val = valID[0];
            int id = valID[1];
            if (!computer.containsKey(id)) {
                int c = pq.poll();
                computer.put(id, c);
                continue;
            }
            ans[id] = computer.get(id);
            pq.add(ans[id]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}