import java.io.*;
import java.util.*;

public class BOJ15683 {


    static class CCTV {
        int type;
        int row;
        int col;

        CCTV(int row,int col,int type) {
            this.row = row;
            this.col = col;
            this.type = type;
        }

        void moveLeft(int row, int col, int[][] toWatch) {
            if (row < 0 || col < 0 || row >= N || col >= M) return;
            if (toWatch[row][col] == 6) return;
            if (toWatch[row][col] == 0) toWatch[row][col] = -1;
            moveLeft(row, col-1, toWatch);
        }

        void moveRight(int row, int col, int[][] toWatch) {
            if (row < 0 || col < 0 || row >= N || col >= M) return;
            if (toWatch[row][col] == 6) return;
            if (toWatch[row][col] == 0) toWatch[row][col] = -1;
            moveRight(row, col+1, toWatch);
        }

        void moveUp(int row, int col, int[][] toWatch) {
            if (row < 0 || col < 0 || row >= N || col >= M) return;
            if (toWatch[row][col] == 6) return;
            if (toWatch[row][col] == 0) toWatch[row][col] = -1;
            moveUp(row-1, col, toWatch);
        }

        void moveDown(int row, int col, int[][] toWatch) {
            if (row < 0 || col < 0 || row >= N || col >= M) return;
            if (toWatch[row][col] == 6) return;
            if (toWatch[row][col] == 0) toWatch[row][col] = -1;
            moveDown(row+1, col, toWatch);
        }
    }
    static int[][] graph;
    static List<CCTV> cctvs;
    static int N,M;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        graph = new int[N][M];
        cctvs = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < M; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
                if (graph[r][c] > 0 && graph[r][c] < 6) cctvs.add(new CCTV(r, c, graph[r][c]));
            }
        }

        BackTracking(0, graph);
        System.out.println(ans);
    }

    static void BackTracking(int cnt, int[][] map) {
        if (cnt == cctvs.size()) {
            ans = Math.min(ans, checkZeros(map));
            return;
        }

        CCTV cctv = cctvs.get(cnt);
        int[][] copied;
        if (cctv.type == 1) {
            // 좌
            copied = copyGraph(map);
            cctv.moveLeft(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);

            // 우
            copied = copyGraph(map);
            cctv.moveRight(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);

            // 상
            copied = copyGraph(map);
            cctv.moveUp(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);

            // 하
            copied = copyGraph(map);
            cctv.moveDown(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);
        } else if (cctv.type == 2) {
            // 상하
            copied = copyGraph(map);
            cctv.moveUp(cctv.row, cctv.col, copied);
            cctv.moveDown(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);

            // 좌우
            copied = copyGraph(map);
            cctv.moveLeft(cctv.row, cctv.col, copied);
            cctv.moveRight(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);
        } else if (cctv.type == 3) {
            // 상우
            copied = copyGraph(map);
            cctv.moveUp(cctv.row, cctv.col, copied);
            cctv.moveRight(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);
            // 우하
            copied = copyGraph(map);
            cctv.moveRight(cctv.row, cctv.col, copied);
            cctv.moveDown(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);
            // 하좌
            copied = copyGraph(map);
            cctv.moveDown(cctv.row, cctv.col, copied);
            cctv.moveLeft(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);
            // 좌상
            copied = copyGraph(map);
            cctv.moveLeft(cctv.row, cctv.col, copied);
            cctv.moveUp(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);
        } else if (cctv.type == 4) {
            // 상 제외
            copied = copyGraph(map);
            cctv.moveLeft(cctv.row, cctv.col, copied);
            cctv.moveRight(cctv.row, cctv.col, copied);
            cctv.moveDown(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);
            // 하 제외
            copied = copyGraph(map);
            cctv.moveLeft(cctv.row, cctv.col, copied);
            cctv.moveRight(cctv.row, cctv.col, copied);
            cctv.moveUp(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);
            // 좌 제외
            copied = copyGraph(map);
            cctv.moveRight(cctv.row, cctv.col, copied);
            cctv.moveUp(cctv.row, cctv.col, copied);
            cctv.moveDown(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);
            // 우 제외
            copied = copyGraph(map);
            cctv.moveLeft(cctv.row, cctv.col, copied);
            cctv.moveUp(cctv.row, cctv.col, copied);
            cctv.moveDown(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);
        }else {
            // 전부
            copied = copyGraph(map);
            cctv.moveLeft(cctv.row, cctv.col, copied);
            cctv.moveRight(cctv.row, cctv.col, copied);
            cctv.moveUp(cctv.row, cctv.col, copied);
            cctv.moveDown(cctv.row, cctv.col, copied);
            BackTracking(cnt+1, copied);
        }
    }

    static int checkZeros(int[][] copied) {
        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (copied[r][c] == 0) cnt++;
            }
        }
        return cnt;
    }

    static int[][] copyGraph(int[][] graph) {
        int[][] copied = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                copied[r][c] = graph[r][c];
            }
        }
        return copied;
    }
}
