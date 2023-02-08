import java.io.*;
import java.util.*;

public class BOJ11660 {
    static int N,M;
    static int[][] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        for (int c = 1; c <= N; c++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int r = 1; r <= N; r++) {
                graph[c][r] = graph[c][r-1] + graph[c-1][r] - graph[c-1][r-1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(graph[x2][y2] - (graph[x2][y1-1] + graph[x1-1][y2] - graph[x1-1][y1-1])).append("\n");
        }
        System.out.println(sb.toString());
    }
}
