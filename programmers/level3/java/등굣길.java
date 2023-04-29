import java.util.*;

class Solution {

    static int[][] graph;

    public int solution(int m, int n, int[][] puddles) {
        graph = new int[m][n];
        for (int[] p : puddles) {
            graph[p[0]-1][p[1]-1] = -1;
        }
        int val = 1;
        for (int i = 0; i < m; i++) {
            if (graph[i][0] == -1) {
                val = 0;
            }
            graph[i][0] = val;
        }

        val = 1;
        for (int i = 0; i < n; i++) {
            if(graph[0][i] == -1) {
                val = 0;
            }
            graph[0][i] = val;
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (graph[r][c] == -1) {
                    graph[r][c] = 0;
                    continue;
                }
                graph[r][c] = (graph[r-1][c] + graph[r][c-1]);
                graph[r][c] %= 1_000_000_007;
            }
        }

        return graph[m-1][n-1];
    }
}