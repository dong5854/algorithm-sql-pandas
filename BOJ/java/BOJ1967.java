import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1967 {
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
    static int ans;

    public static void main(String[] args) throws Exception {
        setUp();
        dfs(1, 0);
        System.out.println(ans);
    }

    private static int dfs(int node, int weight) {
        if (edges[node].size() == 0) {
            return weight;
        }
        // 가장 큰 두개
        int[] bigTwo = new int[2];
        // dfs 로직
        for (Edge edge : edges[node]) {
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
        ans = 0;

        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < V-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
        }
        br.close();
    }
}
