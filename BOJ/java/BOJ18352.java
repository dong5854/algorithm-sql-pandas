import java.util.*;
import java.io.*;

public class BOJ18352 {

    static class Edge implements Comparable<Edge>{
        int node, cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static final int INF = 1_000_001;
    static int N,M,K,X;
    static List<Edge>[] edges;
    static int[] distance;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N+1];
        distance = new int[N+1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            distance[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, 1));
        }

        dijkstra(X);
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) ans.add(i);
        }
        if (ans.size() == 0) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int a : ans) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (distance[current.node] <= current.cost) continue;
            distance[current.node] = current.cost;
            for (Edge next :  edges[current.node]) {
                if (next.cost + current.cost < distance[next.node]) {
                    pq.add(new Edge(next.node, next.cost + current.cost));
                }
            }
        }
    }
}
