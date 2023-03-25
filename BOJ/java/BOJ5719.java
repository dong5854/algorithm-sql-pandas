import java.util.*;
import java.io.*;


public class BOJ5719 {


    static class Edge implements Comparable<Edge>{
        int node, cost;

        public Edge(int node, int cost) {
            super();
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }

    }

    static int N,M;
    static int S,D;

    static final int INF = Integer.MAX_VALUE / 2;
    static List<Edge>[] edges;
    static List<Edge>[] minFrom;
    static int[] dist;
    static boolean[][] visited;
    static int[] almostDist;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            st = new StringTokenizer(br.readLine(), " ");
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            edges = new ArrayList[N];
            minFrom = new ArrayList[N];
            visited = new boolean[N][N];
            dist = new int[N];
            almostDist = new int[N];

            for (int i = 0; i < N; i++) {
                edges[i] = new ArrayList<>();
                minFrom[i] = new ArrayList<>();
                dist[i] = INF;
                almostDist[i] = INF;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from  = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edges[from].add(new Edge(to, cost));
            }

            // 최단경로 구하기
            dijkstra();
//			System.out.println(Arrays.toString(dist));
            backtrack(D);
            // 거의 최단 경로 구하기
            almostdijkstra();
            System.out.println(almostDist[D] == INF ? -1 : almostDist[D]);
        }

        br.close();
    }

    static void backtrack(int to) {
        for (Edge from : minFrom[to]) {
            if (visited[from.node][to]) continue;
            visited[from.node][to] = true;
            if (to == 0) return;
            backtrack(from.node);
        }
    }

    private static void almostdijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(S, 0));
        almostDist[S] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.node == D) return;
            if (almostDist[cur.node] < cur.cost) continue;
            for (Edge next : edges[cur.node]) {
                if (visited[cur.node][next.node]) continue;
                if (cur.cost + next.cost <= almostDist[next.node]) {
                    // pq 에 추가는 하나만 해주면 된다.
                    if (cur.cost + next.cost < almostDist[next.node]) {
                        pq.add(new Edge(next.node, cur.cost + next.cost));
                    }
                    // 최단 경로 갱신
                    almostDist[next.node] = cur.cost + next.cost;
                }
            }
        }
    }

    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(S, 0));
        dist[S] = 0;
        minFrom[S].add(new Edge(S, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.node == D) return;
            if (dist[cur.node] < cur.cost) continue;
            for (Edge next : edges[cur.node]) {
                if (cur.cost + next.cost <= dist[next.node]) {
                    // pq 에 추가는 하나만 해주면 된다.
                    if (cur.cost + next.cost < dist[next.node]) {
                        pq.add(new Edge(next.node, cur.cost + next.cost));
                    }
                    // 최단 경로 갱신
                    dist[next.node] = cur.cost + next.cost;

                    // 최단경로들 추가
                    if (minFrom[next.node].size() == 0) {
                        minFrom[next.node].add(new Edge(cur.node, cur.cost + next.cost));
                    } else if (cur.cost + next.cost == minFrom[next.node].get(0).cost) {
                        minFrom[next.node].add(new Edge(cur.node, cur.cost + next.cost));
                    } else if (cur.cost + next.cost < minFrom[next.node].get(0).cost) {
                        minFrom[next.node].clear();
                        minFrom[next.node].add(new Edge(cur.node, cur.cost + next.cost));
                    }
                }
            }
        }
    }

}