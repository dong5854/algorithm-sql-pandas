import java.util.*;
import java.io.*;

public class BOJ7576 {

    static final int[] dr = {0,0,-1,1};
    static final int[] dc = {1,-1,0,0};

    static int R,C;
    static int[][] graph;
    static ArrayDeque<int[]> deque;
    static int ans;
    public static void main(String[] args) throws Exception {
        setup();
        bfs();
        check();
        System.out.println(ans);
    }
    
    static void check() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (graph[r][c] == 0) {
                    ans = -1;
                    return;
                }
            }
        }
    }

    static void bfs() {
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int cr = cur[0]; int cc = cur[1]; int cDay = cur[2];
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d]; int nc = cc + dc[d];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (graph[nr][nc] == -1 || graph[nr][nc] == 1) continue;    // 이미 익었거나 토마토가 없음
                graph[nr][nc] = -1; // 토마토가 익었다~
                ans = Integer.max(ans, cDay+1);
                deque.add(new int[]{nr, nc, cDay+1});
            }
        }
    }

    static void setup()  throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        ans = 0;

        graph = new int[R][C];
        deque = new ArrayDeque<>();
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < C; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
                if (graph[r][c] == 1) deque.add(new int[] {r,c, 0});
            }
        }
    }
}
