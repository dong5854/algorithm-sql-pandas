import java.io.*;
import java.util.*;

public class BOJ2234 {

    // 서, 북, 동, 남
    static final int[] dr = {0 ,-1, 0, 1};
    static final int[] dc = {-1 ,0, 1, 0};

    static int roomCnt;
    static int maxRoomSpace;
    static int maxRoomWallBreak;

    static int C,R;
    static int[][] graph;
    static int[][] v;
    static boolean[][] connectV;
    static int roomIdx;
    static Map<Integer, Integer> roomMap;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        v = new int[R][C];
        connectV = new boolean[R][C];
        roomIdx = 1;
        roomMap = new HashMap<>();

        roomCnt = 0;
        maxRoomSpace = 0;
        maxRoomWallBreak = 0;

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < C; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (v[r][c] != 0) continue;
                roomCnt++;  // 방의 갯수 증가
                bfs(r, c);
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (connectV[r][c]) continue;
                connectBfs(r, c);
            }
        }

        System.out.println(roomCnt);
        System.out.println(maxRoomSpace);
        System.out.println(maxRoomWallBreak);
    }

    static void connectBfs(int r, int c) {
        connectV[r][c] = true;
        Queue<int[]> q = new ArrayDeque<>();
        // row, col
        q.add(new int[] {r,c});
        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int cRow = polled[0];
            int cCol = polled[1];
            for (int i = 0; i < 4; i++) {
                int nRow = cRow + dr[i];
                int nCol = cCol + dc[i];
                // 벽이 있는 경우 스킵
                if ((graph[cRow][cCol] & (1<<i)) != 0) {
                    if (nRow < 0 || nCol < 0 || nRow >= R || nCol >= C) continue;
                    if (v[cRow][cCol] == v[nRow][nCol]) continue;
                    if (maxRoomWallBreak < roomMap.get(v[cRow][cCol]) + roomMap.get(v[nRow][nCol])) {
                        maxRoomWallBreak = roomMap.get(v[cRow][cCol]) + roomMap.get(v[nRow][nCol]);
                    }

                    continue;
                }
                // 이미 방문했으면 스킵
                if (connectV[nRow][nCol]) continue;
                connectV[nRow][nCol] = true;
                q.add(new int[] {nRow, nCol});
            }
        }
    }

    static void bfs(int r, int c) {
        int cnt = 1;
        v[r][c] = roomIdx;
        Queue<int[]> q = new ArrayDeque<>();
        // row, col
        q.add(new int[] {r,c});
        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int cRow = polled[0];
            int cCol = polled[1];
            for (int i = 0; i < 4; i++) {

                // 벽이 있는 경우 스킵
                if ((graph[cRow][cCol] & (1<<i)) != 0) continue;
                int nRow = cRow + dr[i];
                int nCol = cCol + dc[i];
                // 이미 방문했으면 스킵
                if (v[nRow][nCol] != 0) continue;
                v[nRow][nCol] = roomIdx;
                cnt++;
                q.add(new int[] {nRow, nCol});
            }
        }

        roomMap.put(roomIdx++, cnt);
        maxRoomSpace = Math.max(maxRoomSpace, cnt);
    }
}
