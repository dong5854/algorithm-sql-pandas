import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/14502
class BOJ14502 {

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    static int ans = 0;
    static int walls = 0;
    static int safeZone = 0;
    static int N;
    static int M;
    static int[][] lab;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ans = 0;
        walls = 0;
        safeZone = 0;

        N = sc.nextInt(); // 세로 크기
        M = sc.nextInt(); // 가로 크기

        lab = new int[N][M];
        
        for (int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                lab[r][c] = sc.nextInt();
                if (lab[r][c] == 0) safeZone++;
            }
        }

        backTracking();
        System.out.println(ans);

        sc.close();
    }

    public static void backTracking() {
        if (walls == 3) {
            bfs();
            return;
        }

        for (int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if (lab[r][c] != 0) continue;
                lab[r][c] = 1;
                walls++;
                backTracking();
                lab[r][c] = 0;
                walls--;
            }
        }
    }

    public static void bfs() {
        int infected = 0;   // 감염 된 곳들
        boolean[][] visited = new boolean[N][M];
        Queue<int []> queue = new LinkedList<>();
        for (int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if (lab[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            for (int i = 0; i < dr.length; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(lab[nr][nc] != 0) continue;

                // 방문 표시 후, 감염 카운터 올리기
                visited[nr][nc] = true;
                infected++;
                queue.add(new int[]{nr, nc});
            }
        }
        
        int realSafe = safeZone - infected - walls; // 기존 안전 - 감염 - 세운 벽
        ans = Math.max(ans, realSafe);
    }

}