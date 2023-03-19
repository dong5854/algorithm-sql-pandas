import java.io.*;
import java.util.*;

public class BOJ2887 {

    static class IdxComp implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[1], o2[1]);
        }
    }

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
        int cost, cnt;
        int[] root;
        int[] rank;

        public Kruskal(int n) {
            this.cost = 0;
            this.cnt = 0;
            this.root = new int[n];
            this.rank = new int[n];
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
            cost += edge.cost;
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
            if (cnt == root.length - 1) return true;
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // [행성 번호, 좌표]
        int[][] xVal = new int[N][];
        int[][] yVal = new int[N][];
        int[][] zVal = new int[N][];

        // O(N)
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            xVal[i] = new int[]{i, x};
            yVal[i] = new int[]{i, y};
            zVal[i] = new int[]{i, z};
        }

        // O(NlogN * 3) = > O(NlogN)
        IdxComp idxComp = new IdxComp();
        Arrays.sort(xVal, idxComp);
        Arrays.sort(yVal, idxComp);
        Arrays.sort(zVal, idxComp);

        // O(N)
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N-1; i++) {
            pq.add(new Edge(xVal[i][0], xVal[i+1][0], xVal[i+1][1] - xVal[i][1]));
            pq.add(new Edge(yVal[i][0], yVal[i+1][0], yVal[i+1][1] - yVal[i][1]));
            pq.add(new Edge(zVal[i][0], zVal[i+1][0], zVal[i+1][1] - zVal[i][1]));
        }

        Kruskal kruskal = new Kruskal(N);
        // O(3Nlog3N) => O(NlogN)
        while(!pq.isEmpty()) {
            kruskal.union(pq.poll());
            if (kruskal.done()) {
                System.out.println(kruskal.cost);
                return;
            }
        }
    }
}
