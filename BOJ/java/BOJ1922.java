import java.util.*;
import java.io.*;

public class BOJ1922 {

    static class Edge implements Comparable<Edge>{
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
        int[] root;
        int[] rank;
        int cnt;
        int totalCost;

        public Kruskal(int nodes) {
            this.root = new int[nodes+1];
            this.rank = new int[nodes+1];
            cnt = 0;
            totalCost = 0;
            for (int i = 0; i <= nodes; i++) {
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
            if (rank[rootA] < rank[rootB]) {
                root[rootA] = rootB;
            } else if (rank[rootB] < rank[rootA]) {
                root[rootB] = rootA;
            } else {
                root[rootB] = rootA;
                rank[rootA]++;
            }
        }

        public boolean done() {
            if (cnt == root.length-2) return true;
            return false;
        }
    }
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int  i = 0; i < M; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine(), " ");
            pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Kruskal kruskal = new Kruskal(N);
        while (!pq.isEmpty()) {
            kruskal.union(pq.poll());
            if (kruskal.done()) {
                System.out.println(kruskal.totalCost);
                return;
            }
        }
    }
}
