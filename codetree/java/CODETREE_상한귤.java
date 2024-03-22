import java.io.*;
import java.util.*;

public class CODETREE_상한귤 {

    static final int[] dx = {0,1,-1,0};
    static final int[] dy = {1,0,0,-1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] original = new int[N][N];
        int[][] time = new int[N][N];

        // {x, y, time}
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                original[i][j] = Integer.parseInt(st.nextToken());
                if (original[i][j] == 0) {
                    time[i][j] = -1;
                } else if (original[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                } else {
                    time[i][j] = -2;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curTime = cur[2];
            time[curX][curY] = curTime;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                int nextTime = curTime + 1;
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if (original[nextX][nextY] != 1) continue;
                original[nextX][nextY] = 2;
                q.add(new int[]{nextX, nextY, nextTime});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(time[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}