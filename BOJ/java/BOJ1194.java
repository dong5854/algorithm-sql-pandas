import java.io.*;
import java.util.*;

class BOJ1194 {

    static final int INF = Integer.MAX_VALUE / 2;
    static final int[] dr = new int[] { 0, 0, -1, 1 };
    static final int[] dc = new int[] { 1, -1, 0, 0 };


    static char[][] graph;
    static int[][][] dp;
    static int R, C;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        // 키는 0 ~ 5 까지 비트마스킹
        dp = new int[R][C][(1 << 6)];
        int[] start = new int[2];
        List<int[]> goals = new ArrayList<>();
        
        for (int r = 0; r < R; r++) {
            String row = br.readLine();
            for (int c = 0; c < C; c++) {
                graph[r][c] = row.charAt(c);
                Arrays.fill(dp[r][c], INF);
                if (graph[r][c] == '0') {
                    start[0] = r;
                    start[1] = c;
                }
                if (graph[r][c] == '1') {
                    goals.add(new int[] {r, c});
                }
            }
        }

        bfs(start[0], start[1], 0);

        int ans = INF;

        for (int[] goal : goals) {
            for (int a : dp[goal[0]][goal[1]]) {
                if (ans > a) {
                    ans = a;
                }
            }
        }

        if (ans == INF)
            System.out.println(-1);
        else
            System.out.println(ans);
        br.close();
    }

    private static void bfs(int row, int col, int key) {
        // row, col, key 순서
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { row, col, 0 , 0});
        dp[row][col][0] = 0;
        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int cRow = polled[0];
            int cCol = polled[1];
            int cKey = polled[2];
            int cCnt = polled[3];
            for (int i = 0; i < 4; i++) {
                int nRow = cRow + dr[i];
                int nCol = cCol + dc[i];
                if (nRow < 0 || nCol < 0 || nRow >= R || nCol >= C) // 범위 밖 스킵
                    continue;
                if (graph[nRow][nCol] == '#')   // 벽 스킵
                    continue;
                if (graph[nRow][nCol] >= 'A' && graph[nRow][nCol] <= 'F') { // 문이 있는 경우
                    int reqKey = graph[nRow][nCol] - 'A';
                    if ((cKey & (1 << reqKey)) == 0) { // 키가 없으면 스킵
                        continue;
                    }
                }

                if (graph[nRow][nCol] >= 'a' && graph[nRow][nCol] <= 'f') { // 열쇠가 있는 경우
                    int acqKey = graph[nRow][nCol] - 'a';
                    int nKey = (cKey | (1 << acqKey)); // 열쇠 습득
                    if (dp[nRow][nCol][nKey] > cCnt + 1) {
                        dp[nRow][nCol][nKey] = cCnt + 1;
                        q.add(new int[] { nRow, nCol, nKey, cCnt + 1 });
                        continue;
                    }
                }

                if (dp[nRow][nCol][cKey] > cCnt + 1) {
                    dp[nRow][nCol][cKey] = cCnt + 1;
                    q.add(new int[] { nRow, nCol, cKey, cCnt + 1 });
                }
                
            }
        }
    }
}
