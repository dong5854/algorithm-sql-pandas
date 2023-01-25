import java.util.Scanner;

//https://www.acmicpc.net/problem/14503
public class BOJ14503 {
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int N;
    static int M;
    static int r;
    static int c;
    static int d;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        ans = 1; // 시작한 곳은 청소 했으니까 1

        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        map[r][c] = 2;
        dfs(r, c, 0);
        System.out.println(ans);
    }

    public static void dfs(int row, int col, int cnt) {
        if (cnt > 3) { // 4 방향 전부 탐색한 경우
            // 뒤로가기
            int nr = row - dr[d];
            int nc = col - dc[d];

            if (nr >= N || nc >= M || nr < 0 || nc < 0) return;
            if (map[nr][nc] == 1) return;
            dfs(nr, nc, 0);
            return;
        }
        if (d == 0) d = 3;      // 북쪽 -> 서쪽
        else if (d == 1) d = 0; // 동쪽 -> 북쪽
        else if (d == 2) d = 1; // 남쪽 -> 동쪽
        else if (d == 3) d = 2; // 서쪽 -> 남쪽

        int nr = row + dr[d];
        int nc = col + dc[d];

        if (nr > N || nc > M || nr < 0 || nc < 0) dfs(row, col, cnt + 1);

        if (map[nr][nc] == 0) { // 청소가 안된 경우
            map[nr][nc] = 2;
            ans++;
            dfs(nr, nc, 0);
            return;
        }
        dfs(row, col, cnt + 1);
    }
}
