import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890 {

  static int N, L;
  static int[][] graph;

  public static void main(String[] args) throws Exception {
    getInfo();

    int ans = 0;
    boolean[][] v = new boolean[N][N];

    // 가로방향
    nextRow: for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        if (c <= L && c > N - L) {
          // 여기도 처리해주기
        }
        if (c > L) { // 오르막 체크
          if (graph[r][c - 1] - graph[r][c] > 1) // 높이 차이가 너무 큰 경우
            continue nextRow;

          if (graph[r][c - 1] - graph[r][c] == 1) { // 높이 차이가 딱 맞을 경우
            int reqHeight = graph[r][c - 1];
            for (int s = 1; s <= L; s++) { // 다리를 놓을 수 있는지 체크
              if (c - s < 0)
                continue nextRow;
              if (graph[r][c - s] != reqHeight)
                continue nextRow;
              if (v[r][c - s])
                continue nextRow;
            }
            for (int s = 1; s <= L; s++) { // 다리를 놓는다.
              v[r][c - s] = true;
            }
          }
        }

        if (c <= N - L) { // 내리막 체크
          if (graph[r][c] - graph[r][c + 1] > 1)
            continue nextRow;

          if (graph[r][c] - graph[r][c + 1] == 1) { // 높이 차이가 딱 맞을 경우
            int reqHeight = graph[r][c + 1];
            for (int s = 1; s <= L; s++) { // 다리를 놓을 수 있는지 체크
              if (c + s >= N)
                continue nextRow;
              if (graph[r][c + s] != reqHeight)
                continue nextRow;
              if (v[r][c + s])
                continue nextRow;
            }
            for (int s = 1; s <= L; s++) { // 다리를 놓는다.
              v[r][c + s] = true;
            }
          }
        }
      }
      ans++; // 다리를 놓아서라도 이동할 수 있으면 증가
    }

    System.out.println(ans);
  }

  static void getInfo() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    graph = new int[N][N];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int c = 0; c < N; c++) {
        graph[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }
}
