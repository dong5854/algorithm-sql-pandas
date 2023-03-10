import java.io.*;
import java.util.*;

public class BOJ1647 {

    static class Edge implements Comparable<Edge> {
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static class Kruskal {
        int totalCost, cnt, maxCost;
        int[] root;
        int[] rank;

        public Kruskal(int n) {
            this.totalCost = 0;
            this.cnt = 0;
            this.maxCost = 0;
            this.rank = new int[n+1];
            this.root = new int[n+1];
            for (int i = 0; i <= n; i++) {
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }
        public int find(int node) {
            if (root[node] == node) {
                return root[node];
            }
            return root[node] = find(root[node]);
        }

        public void union(Edge edge) {
            int rootA = find(edge.from);
            int rootB = find(edge.to);
            if (rootA == rootB) return;
            this.cnt++;
            this.totalCost += edge.cost;
            if (this.maxCost < edge.cost) {
                this.maxCost = edge.cost;
            }
            if (rank[rootA] < rank[rootB]) {
                root[rootA] = rootB;
            } else if (rank[rootB] < rank[rootA]) {
                root[rootB] = rootA;
            } else {
                root[rootA] = rootB;
                rank[rootB]++;
            }
        }

        public boolean done() {
            if (cnt == root.length - 2) return true;
            return false;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Kruskal kruskal = new Kruskal(N);
        while (!pq.isEmpty()) {
            kruskal.union(pq.poll());
            if (kruskal.done()) {
                System.out.println(kruskal.totalCost - kruskal.maxCost);
                return;
            }
        }
    }
}
