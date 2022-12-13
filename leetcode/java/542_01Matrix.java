// https://leetcode.com/problems/01-matrix/description/
// /*
//  * 시간초과 난 코드, 반복문을 돌면서 bfs를 전부 해서 생긴 문제
//  */
// import java.util.*;
// class Solution {
//     // 위, 아래, 왼족, 오른쪽
//     int[] dr = new int[]{-1,1,0,0};
//     int[] dc = new int[]{0,0,-1,1};

//     public int[][] updateMatrix(int[][] mat) {
//         int[][] answer = new int[mat.length][mat[0].length];
        
//         for (int i = 0; i < mat.length; i++) {
//             for (int j = 0; j < mat[0].length; j++) {
//                 answer[i][j] = bfs(i,j,mat);
//             }
//         }
//         return answer;
//     }

//     public int bfs(int row, int col, int[][] mat) {
//         if (mat[row][col] == 0) return 0;
//         boolean[][] visited = new boolean[mat.length][mat[0].length];
//         Deque<int[]> deque = new ArrayDeque<>();
//         visited[row][col] = true;
//         deque.add(new int[]{row, col, 0});
//         while (!deque.isEmpty()) {
//             int[] cur = deque.pop();
//             int curRow = cur[0], curCol = cur[1], curCnt = cur[2];
//             for (int i = 0; i < 4; i++) {
//                 int nextRow = curRow + dr[i];
//                 int nextCol = curCol + dc[i];
//                 int nextCnt = curCnt + 1;
//                 if (nextRow < 0 || nextCol < 0 || nextRow >= mat.length || nextCol >= mat[0].length) continue;
//                 if (visited[nextRow][nextCol]) continue;
//                 if (mat[nextRow][nextCol] == 0) return nextCnt;
//                 visited[nextRow][nextCol] = true;
//                 deque.add(new int[]{nextRow, nextCol, nextCnt});
//             }
//         }
//         return 0;
//     }
// }
/*
 * 큐에 0인 경우들얼 넣어 준 후 bfs를 한번만 돌려도 되도록 최적화한 코드
 */
import java.util.*;;
class Solution {
    // 위, 아래, 왼족, 오른쪽
    int[] dr = new int[]{-1,1,0,0};
    int[] dc = new int[]{0,0,-1,1};

    public int[][] updateMatrix(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    deque.add(new int[]{i, j});
                    visited[i][j] = true;
                };
            }
        }
        bfs(mat, deque, visited);
        return mat;
    }

    public void bfs(int[][] mat, Deque<int[]>deque, boolean[][] visited) {
        while (!deque.isEmpty()) {
            int[] cur = deque.pop();
            int curRow = cur[0], curCol = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if (nextRow < 0 || nextCol < 0 || nextRow >= mat.length || nextCol >= mat[0].length) continue;
                if (visited[nextRow][nextCol]) continue;
                mat[nextRow][nextCol] = mat[curRow][curCol] + 1;
                visited[nextRow][nextCol] = true;
                deque.add(new int[]{nextRow, nextCol});
            }
        }
        return;
    }
}
