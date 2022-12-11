// https://leetcode.com/problems/flood-fill/description/?envType=study-plan&id=algorithm-i
class Solution {
    // 위, 아래, 왼쪽, 오른쪽
    int[] dc = new int[]{-1,1,0,0};
    int[] dr = new int[]{0,0,-1,1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) dfs(image, sr, sc, color);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color) {
        int originalColor = image[r][c];
        image[r][c] = color;
        for (int i = 0; i < 4; i++) {
            int nc = c + dc[i];
            int nr = r + dr[i];
            if (nr < 0 || nc < 0 || nr >= image.length || nc >= image[0].length) continue;
            if (image[nr][nc] == originalColor) {
                dfs(image, nr, nc, color);
            }
        }
        return;
    }
}