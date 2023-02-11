// https://leetcode.com/problems/number-of-islands/

import java.util.*;

class Solution {

    public static int ans = 0;
    
    // 우, 좌, 상, 하
    public static int[] dr = {0, 0, -1, 1};
    public static int[] dc = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        ans = 0;

        int n = grid.length;
        int m = grid[0].length;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                bfs(grid, r, c);
            }
        }
        return ans;
    }

    public void bfs(char[][] grid, int r, int c) {
        if (grid[r][c] == '0') return;
        grid[r][c] = '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0], cc = cur[1];

            for(int i = 0; i < dr.length; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) continue;
                if(grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        ans++;
    }
}