import java.io.*;
import java.util.*;

public class BOJ11779 {

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

    static int N, M;
    static int[] dist;
    static ArrayList<Integer>[] minRoute;
    static ArrayList<Edge>[] edges;
    static int start, end;
    public static void main(String[] args) throws Exception {
        setUp();
        dijkstra();
    }

    public static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // 자기 자신으로 가는 경로는 0
        pq.add(new Edge(start, 0));
        minRoute[start].add(start);

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.node == end) {
                StringBuilder sb = new StringBuilder();
                sb.append(dist[end]).append("\n");
                sb.append(minRoute[end].size()).append("\n");
                for (Integer r : minRoute[end]) {
                    sb.append(r).append(" ");
                }
                System.out.println(sb);
                return;
            }
            if (dist[cur.node] < cur.cost) continue;    // 이미갱신된 경우 스킵
            for (Edge edge : edges[cur.node]) {
                if (dist[edge.node] > cur.cost + edge.cost) {   // 거쳐가는 경우가 더 짧으면,
                    dist[edge.node] = cur.cost + edge.cost;     // 갱신 후,
                    // 이동 루트 갱신
                    minRoute[edge.node] = new ArrayList<>(minRoute[cur.node]);
                    minRoute[edge.node].add(edge.node);
                    // pq에 추가
                    pq.add(new Edge(edge.node, cur.cost + edge.cost));
                }
            }
        }
    }

    public static void setUp() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N+1];
        minRoute = new ArrayList[N+1];
        edges = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            minRoute[i] = new ArrayList<>();
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (from == to) continue;
            edges[from].add(new Edge(to, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        br.close();
    }
}
