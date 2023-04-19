import java.io.*;
import java.util.*;

class 게임맵최단거리 {
    
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    
    static int ans;
    
    public int solution(int[][] maps) {
        ans = -1;
        boolean[][] v = new boolean[maps.length][maps[0].length];
        bfs(maps, v);
        return ans;
    }
    
    public void bfs(int[][] map, boolean[][] v) {
        int mRow = map.length;
        int mCol = map[0].length;
        int dRow = map.length - 1;
        int dCol = map[0].length - 1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0,1});
        v[0][0] = true;
        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int cRow = polled[0];
            int cCol = polled[1];
            int cCnt = polled[2];
            for (int i = 0; i < 4; i++) {
                int nRow = cRow + dr[i];
                int nCol = cCol + dc[i];
                if (nRow < 0 || nCol < 0 || nRow >= mRow || nCol >= mCol) {
                    continue;
                }
                if (map[nRow][nCol] == 0 || v[nRow][nCol]) {
                    continue;
                }
                v[nRow][nCol] = true;
                if (nRow == dRow && nCol == dCol) {
                    ans = cCnt + 1;
                    break;
                }
                q.add(new int[] {nRow, nCol, cCnt + 1});
            }
        }
    }
}