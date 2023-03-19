import java.io.*;
import java.util.*;

public class BOJ4386 {

    static class Edge implements Comparable<Edge> {
        int from, to;
        double cost;

        public Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    static class Kruskal {
        int[] root;
        int[] rank;
        int cnt;
        double totalCost;

        public Kruskal(int n) {
            this.root = new int[n];
            this.rank = new int[n];
            this.cnt = 0;
            this.totalCost = 0;
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
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
            cnt++;
            totalCost += edge.cost;
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
            if (cnt == rank.length - 1) return true;
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[][] coordinates = new double[N][2]; // [x,y]
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // O(N^2*logN)
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            coordinates[i] = new double[]{x,y};
            for (int c = 0; c < i; c++) {
                pq.add(new Edge(i, c, getDistance(coordinates[c][0], coordinates[c][1], x, y)));
            }
        }

        Kruskal kruskal = new Kruskal(N);
        while (!pq.isEmpty()) {
            kruskal.union(pq.poll());
            if (kruskal.done()) {
                System.out.println(Math.round(kruskal.totalCost * 100) / 100.0);
                return;
            }
        }
    }

    public static double getDistance(double x1, double y1, double x2, double y2) {
        double a = Math.abs(x1 - x2);
        double b = Math.abs(y1 - y2);
        double pythagorasSum = Math.pow(a, 2) + Math.pow(b, 2);
        return Math.sqrt(pythagorasSum);
    }
}
