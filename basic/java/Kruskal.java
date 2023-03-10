import java.util.*;

public class Kruskal {

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

    static class KruskalUnionFind {
        int[] root;
        int[] rank;
        int cnt;
        int totalCost;

        public KruskalUnionFind(int nodes) {
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
    public static void main(String[] args) throws Exception {
        int N = 6;  // 노드의 수

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1,2,5));
        pq.add(new Edge(1,3,4));
        pq.add(new Edge(2,3,2));
        pq.add(new Edge(2,4,7));
        pq.add(new Edge(3,4,6));
        pq.add(new Edge(3,5,11));
        pq.add(new Edge(4,5,3));
        pq.add(new Edge(4,6,8));
        pq.add(new Edge(5,6,8));
        

        KruskalUnionFind kruskal = new KruskalUnionFind(N);
        while (!pq.isEmpty()) {
            kruskal.union(pq.poll());
            if (kruskal.done()) {
                System.out.println(kruskal.totalCost);
                return;
            }
        }
    }
}
