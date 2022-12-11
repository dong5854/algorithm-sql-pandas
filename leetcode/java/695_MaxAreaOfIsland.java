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
// /*
//  * stack 을 활용해 재귀가 아닌 반복문으로 dfs를 진행하는 방법 또한 있다.
//  */
// class Solution {
//     int[] dr = new int[]{1, -1, 0, 0};
//     int[] dc = new int[]{0, 0, 1, -1};

//     public int maxAreaOfIsland(int[][] grid) {
//         int ans = 0;
//         for (int r = 0; r < grid.length; r++) {
//             for (int c = 0; c < grid[r].length; c++) {
//                 ans = Math.max(ans, dfs(grid, r, c));
//             }
//         }
//         return ans;
//     }
//     public int dfs(int[][] grid, int r, int c) {
//         if (grid[r][c] == 0) return 0;
//         int area = 0;
//         Stack<int[]> stack = new Stack<>();
//         stack.push(new int[]{r, c});
//         grid[r][c] = 0;
//         while(!stack.empty()) {
//             int[] node = stack.pop();
//             int cr = node[0], cc = node[1];
//             area++;
//             for (int i =0; i < 4; i++) {
//                 int nr = cr + dr[i];
//                 int nc = cc + dc[i];
//                 if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) continue;
//                 if (grid[nr][nc] == 0) continue;
//                 stack.push(new int[]{nr, nc});
//                 grid[nr][nc] = 0;
//             }
//         }
//         return area;
//     }
// }