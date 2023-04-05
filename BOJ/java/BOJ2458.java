import java.io.*;
import java.util.*;

public class Main_bj_2458_키순서_서울_20반_이동영 {

  static final int INF = Integer.MAX_VALUE / 2;

  static int N, M;
  static int[][] graph;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new int[N + 1][N + 1];

    for (int r = 1; r <= N; r++) {
      for (int c = 1; c <= N; c++) {
        graph[r][c] = INF;
      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      graph[from][to] = 1;
    }

    for (int k = 1; k <= N; k++) {
      for (int r = 1; r <= N; r++) {
        for (int c = 1; c <= N; c++) {
          graph[r][c] = Math.min(graph[r][c], graph[r][k] + graph[k][c]);
        }
      }
    }

    int ans = 0;
    for (int target = 1; target <= N; target++) {
      int temp = 0;
      for (int dest = 1; dest <= N; dest++) {
        if (graph[target][dest] != INF || graph[dest][target] != INF) {
          temp++;
        }
      }
      if (temp == N - 1) {
        ans++;
      }
    }

    System.out.println(ans);
    br.close();
  }
}
