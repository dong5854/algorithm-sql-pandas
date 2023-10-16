import java.io.*;
import java.util.*;

public class CODETREE_각정점까지의최단경로2 {

    static final int INF = Integer.MAX_VALUE/ 2;

    static int n, m;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        for (int r = 0; r <= n; r++) {
            for (int c = 0; c <= n; c++) {
                if (r == c) graph[r][c] = 0;
                else graph[r][c] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            graph[row][col] = Math.min(graph[row][col], val);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(graph[i][j] == INF ? -1 : graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}