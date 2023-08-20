import java.io.*;
import java.util.*;

public class BOJ11725 {

    public static void main(String[] args) throws IOException {
        Map<Integer, Set<Integer>> graph = setGraph();
        int[] p = new int[graph.size() + 1];
        bfs(graph, p);
        for (int  i = 2; i < p.length; i++) {
            System.out.println(p[i]);
        }
    }

    public static void bfs(Map<Integer, Set<Integer>> graph, int[] p) {
        p[1] = 1;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        while(!q.isEmpty()) {
            int from = q.poll();
            for (int to : graph.get(from)) {
                if (p[to] != 0) continue;
                p[to] = from;
                q.add(to);
            }
        }
    }

    public static Map<Integer, Set<Integer>> setGraph() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Set<Integer>>graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i , new HashSet<>());
        }
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
            graph.get(a).add(b);
        }
        return graph;
    }
}
