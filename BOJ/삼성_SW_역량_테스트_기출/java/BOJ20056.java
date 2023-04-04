import java.io.*;
import java.util.*;

public class BOJ20056 {

  // 시계방향
  static final int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
  static final int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

  static List<Fireball> fireballs;
  static Fireball[][] graph;

  static int N, M, K;

  static class Fireball {

    // 모두 홀수이거나 모두 짝수면 true (0, 2, 4, 6)
    // 아니면 false (1, 3, 5, 7)
    boolean splitDir;
    int cnt;
    int r;
    int c;
    int m;
    int d;
    int s;

    public Fireball(int r, int c, int m, int d, int s) {
      splitDir = true;
      cnt = 1;
      this.r = r;
      this.c = c;
      this.m = m;
      this.d = d;
      this.s = s;
    }

    public void consume(Fireball fireball) {
      if (this.d % 2 != fireball.d % 2) {
        this.splitDir = false;
      }
      cnt += fireball.cnt;
      this.m += fireball.m;
      this.s += fireball.s;
    }

    public void move() {
      this.r += this.s * dr[this.d];
      this.c += this.s * dc[this.d];

      this.r %= N;
      if (this.r == 0) {
        this.r = N;
      } else if (this.r < 0) {
        this.r = N + this.r;
      }

      this.c %= N;
      if (this.c == 0) {
        this.c = N;
      } else if (this.c < 0) {
        this.c = N + this.c;
      }
    }

    public Fireball[] split() {
      Fireball[] ret = new Fireball[4];
      int splitedM = this.m / 5;
      int splitedS = this.s / cnt;
      for (int i = 0; i < 4; i++) {
        if (this.splitDir) {
          ret[i] = new Fireball(this.r, this.c, splitedM, i * 2, splitedS);
        } else {
          ret[i] = new Fireball(this.r, this.c, splitedM, i * 2 + 1, splitedS);
        }
      }
      return ret;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    fireballs = new ArrayList<>();
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    // 파이어볼 입력
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      fireballs.add(new Fireball(r, c, m, d, s));
    }

    // 명령 횟수
    for (int k = 0; k < K; k++) {
      graph = new Fireball[N + 1][N + 1];
      // 상어이동 후 그래프에 추가
      for (int i = 0; i < fireballs.size(); i++) {
        Fireball fireball = fireballs.get(i);
        fireball.move();
        if (graph[fireball.r][fireball.c] == null) {
          graph[fireball.r][fireball.c] = fireball;
        } else {
          graph[fireball.r][fireball.c].consume(fireball);
        }
      }

      List<Fireball> newFireballs = new ArrayList<>();
      for (int r = 1; r <= N; r++) {
        for (int c = 1; c <= N; c++) {
          if (graph[r][c] == null)
            continue;
          if (graph[r][c].cnt == 1) {
            newFireballs.add(graph[r][c]);
            continue;
          }

          Fireball[] splited = graph[r][c].split();
          for (Fireball fireball : splited) {
            if (fireball.m != 0) {
              newFireballs.add(fireball);
            }
          }
        }
      }
      fireballs = newFireballs;
    }

    // 총 질량의 합
    int sum = 0;
    for (Fireball fireball : fireballs) {
      sum += fireball.m;
    }
    System.out.println(sum);
    br.close();
  }
}
