import java.io.*;
import java.util.*;

class BOJ4485 {

    static final int[] dr = { 0, 0, -1, 1 };
    static final int[] dc = { 1, -1, 0, 0 };

    static final int INF = Integer.MAX_VALUE / 2;
    static int N;
    static int[][] cave;
    static int[][] dist;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 0;

        while (true) {
            N = Integer.parseInt(br.readLine());
            tc++;
            if (N == 0)
                break;

            dist = new int[N][N];
            cave = new int[N][N];

            for (int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < N; c++) {
                    cave[r][c] = Integer.parseInt(st.nextToken());
                    dist[r][c] = INF;
                }
            }

            dijkstra(0, 0);
            sb.append("Problem ").append(tc).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void dijkstra(int row, int col) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> Integer.compare(o1[2], o2[2]));
        pq.add(new int[] { row, col, cave[row][col] });
        dist[row][col] = cave[row][col];

        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int cRow = polled[0];
            int cCol = polled[1];
            int cCost = polled[2];

            for (int i = 0; i < 4; i++) {
                int nRow = cRow + dr[i];
                int nCol = cCol + dc[i];
                if (nRow < 0 || nCol < 0 || nRow >= N || nCol >= N)
                    continue;
                if (dist[nRow][nCol] <= cCost + cave[nRow][nCol])
                    continue;
                dist[nRow][nCol] = cCost + cave[nRow][nCol];
                pq.add(new int[] { nRow, nCol, dist[nRow][nCol] });
            }
        }
        
    }

}