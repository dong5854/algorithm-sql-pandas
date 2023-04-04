import java.io.*;
import java.util.*;

public class BOJ20057 {

  // 좌, 하, 우, 상
  static final int[] dr = { 0, 1, 0, -1 };
  static final int[] dc = { -1, 0, 1, 0 };

  static int N;
  static int[][] graph;

  static int ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    graph = new int[N][N];
    ans = 0;

    for (int r = 0; r < N; r++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int c = 0; c < N; c++) {
        graph[r][c] = Integer.parseInt(st.nextToken());
      }
    }
    solve(N / 2, N / 2);

    System.out.println(ans);
  }

  static void solve(int row, int col) {
    int move = 0;
    while (true) {
      for (int d = 0; d < 4; d++) {
        // 좌 - > 우, 우 -> 좌에서 하나 늘어난다.
        if (d == 0 || d == 2) {
          move++;
        }
        for (int m = 0; m < move; m++) { // move 번 이동
          row += dr[d];
          col += dc[d];
          int notAlpha = 0;
          int dust = 0;
          try {
            dust = graph[row][col];
            graph[row][col] = 0;
          } catch (IndexOutOfBoundsException e) {
            row -= dr[d];
            col -= dc[d];
            continue;
          }

          // ---------- 아래 ----------
          int downR = dr[(d + 1) % 4];
          int downC = dc[(d + 1) % 4];
          // 아래 한칸
          try {
            notAlpha += dust * 0.07;
            graph[row + downR][col + downC] += dust * 0.07;
          } catch (IndexOutOfBoundsException e) {
            ans += dust * 0.07;
          }

          // 아래 두칸
          try {
            notAlpha += dust * 0.02;
            graph[row + 2 * downR][col + 2 * downC] += dust * 0.02;
          } catch (IndexOutOfBoundsException e) {
            ans += dust * 0.02;
          }

          // ---------- 위 ----------
          int upR = dr[(d + 3) % 4];
          int upC = dc[(d + 3) % 4];

          // 위 한칸
          try {
            notAlpha += dust * 0.07;
            graph[row + upR][col + upC] += dust * 0.07;
          } catch (IndexOutOfBoundsException e) {
            ans += dust * 0.07;
          }

          // 위 두칸
          try {
            notAlpha += dust * 0.02;
            graph[row + 2 * upR][col + 2 * upC] += dust * 0.02;
          } catch (IndexOutOfBoundsException e) {
            ans += dust * 0.02;
          }

          // ---------- 앞 ----------
          int fwdR = dr[d];
          int fwdC = dc[d];
          // 앞 두칸
          try {
            notAlpha += dust * 0.05;
            graph[row + 2 * fwdR][col + 2 * fwdC] += dust * 0.05;
          } catch (IndexOutOfBoundsException e) {
            ans += dust * 0.05;
          }

          // ---------- 대각선 ----------
          int backR = dr[(d + 2) % 4];
          int backC = dc[(d + 2) % 4];

          // 앞 위
          try {
            notAlpha += dust * 0.1;
            graph[row + fwdR + upR][col + fwdC + upC] += dust * 0.1;
          } catch (IndexOutOfBoundsException e) {
            ans += dust * 0.1;
          }

          // 앞 아래
          try {
            notAlpha += dust * 0.1;
            graph[row + fwdR + downR][col + fwdC + downC] += dust * 0.1;
          } catch (IndexOutOfBoundsException e) {
            ans += dust * 0.1;
          }

          // 뒤 위
          try {
            notAlpha += dust * 0.01;
            graph[row + backR + upR][col + backC + upC] += dust * 0.01;
          } catch (IndexOutOfBoundsException e) {
            ans += dust * 0.01;
          }

          // 뒤 아래
          try {
            notAlpha += dust * 0.01;
            graph[row + backR + downR][col + backC + downC] += dust * 0.01;
          } catch (IndexOutOfBoundsException e) {
            ans += dust * 0.01;
          }

          // 알파
          try {
            graph[row + fwdR][col + fwdC] += (dust - notAlpha);
          } catch (IndexOutOfBoundsException e) {
            ans += (dust - notAlpha);
          }

        }
        if (row == 0 && col == 0)
          return;
      }
    }
  }
}
