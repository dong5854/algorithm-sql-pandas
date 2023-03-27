import java.util.*;

class 섬연결하기 {
    
    class UnionFind {
        int[] root;
        int totalCost;
        int cnt;
        
        public UnionFind(int nodes) {
            root = new int[nodes];
            totalCost = 0;
            cnt = 0;
            for (int i = 0; i < nodes; i++) {
                root[i] = i;
            }
        }
        
        private int find(int node) {
            if (root[node] == node) {
                return root[node];
            }
            return root[node] = find(root[node]);
        }
        
        private void union(Edge edge) {
            int rootA = find(edge.from);
            int rootB = find(edge.to);
            if (rootA == rootB) return;
            root[rootA] = rootB;
            cnt++;
            totalCost += edge.cost;
        }
        
        public boolean isDone() {
            if (cnt == root.length - 1) return true;
            return false;
        }
    }
    
    class Edge implements Comparable<Edge> {
        
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
    
    List<Edge> edges = new ArrayList<>();
    public int solution(int n, int[][] costs) {
        for(int [] cost : costs) {
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }
        Collections.sort(edges);
        
        UnionFind unionFind = new UnionFind(n);
        for (Edge edge : edges) {
            unionFind.union(edge);
            if (unionFind.isDone());
        }
        
        return unionFind.totalCost;
    }
}