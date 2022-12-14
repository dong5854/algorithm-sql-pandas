// https://leetcode.com/problems/rotting-oranges/description/?envType=study-plan&id=algorithm-i
import java.util.*;;
class Solution {

    int[][] direction = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int orangesRotting(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) deque.add(new int[]{i, j, 0});
            }
        }
        int minMinutes = bfs(grid, deque);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return minMinutes;
    }

    public int bfs(int[][] grid, Deque<int[]> deque) {
        int minMinutes = 0;
        while (!deque.isEmpty()) {
            int[] current =  deque.pop();
            int currentRow = current[0], currentCol = current[1], currentCnt = current[2];
            for (int[] dir: direction) {
                int nextRow = currentRow + dir[0], nextCol = currentCol + dir[1], nextCnt = currentCnt + 1;
                if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length) continue;
                if (grid[nextRow][nextCol] == 1) {
                    minMinutes = Math.max(minMinutes, nextCnt);
                    grid[nextRow][nextCol] = 2;
                    deque.add(new int[]{nextRow, nextCol, nextCnt});
                }
            }
        }
        return minMinutes;
    }
}