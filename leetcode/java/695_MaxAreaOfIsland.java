// https://leetcode.com/problems/max-area-of-island/description/?envType=study-plan&id=algorithm-i
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                ans = Math.max(ans, dfs(grid, r, c));
            }
        }
        return ans;
    }
    public int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return 0;
        if (grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        return (1 + dfs(grid, r-1, c) + dfs(grid, r+1, c) + dfs(grid, r, c-1) + dfs(grid, r, c+1));
    }
}