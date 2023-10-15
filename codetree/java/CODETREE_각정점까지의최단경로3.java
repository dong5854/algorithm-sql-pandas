import java.util.*;
import java.io.*;

public class CODETREE_각정점까지의최단경로3 {

    static final int INF = Integer.MAX_VALUE;

    static int n;
    static int m;
    static int[] dist;
    static List<List<Edge>> edges;

    static class Edge implements Comparable<Edge>{

        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        edges = new ArrayList<>(n+1);

        Arrays.fill(dist, INF);
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(f).add(new Edge(t, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue();
        dist[1] = 0;
        for (Edge e : edges.get(1)) {
            pq.add(e);
        }

        while(!pq.isEmpty()) {
            Edge polled = pq.poll();
            if (dist[polled.to] > polled.weight) {
                dist[polled.to] = polled.weight;
                for (Edge e : edges.get(polled.to)) {
                    Edge temp = new Edge(e.to, polled.weight + e.weight);
                    pq.add(temp);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if (dist[i] == INF) sb.append(-1);
            else sb.append(dist[i]);
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}