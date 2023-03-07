import java.util.*;
import java.io.*;
public class BOJ1167 {
    static class Edge {
        int vertex;
        int weight;
        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    static int V;
    static List<Edge>[] edges;
    static boolean[] v;
    static int ans;

    public static void main(String[] args) throws Exception {
        setUp();
        dfs(1, 0);
        System.out.println(ans);
    }

    private static int dfs(int node, int weight) {
        v[node] = true;
        // 가장 큰 두개
        int[] bigTwo = new int[2];
        // dfs 로직
        for (Edge edge : edges[node]) {
            if (v[edge.vertex]) continue;
            int temp = dfs(edge.vertex, edge.weight);
            if (bigTwo[0] < temp) {
                bigTwo[0] = temp;
                Arrays.sort(bigTwo);
            }
        }
        if (ans < (bigTwo[0] + bigTwo[1])) {
            ans = bigTwo[0] + bigTwo[1];
        }
        return weight + bigTwo[1];
    }

    static void setUp() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        edges = new ArrayList[V+1];
        v = new boolean[V+1];
        ans = 0;

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            edges[from] = new ArrayList<>();
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                edges[from].add(new Edge(to, weight));
            }
        }
        br.close();
    }
}
