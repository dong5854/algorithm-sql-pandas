// https://leetcode.com/problems/reshape-the-matrix/description/
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (r*c != n*m) return mat;
        int[][] ans = new int[r][c];
        for (int i=0; i < r*c; i++) {
            ans[i/c][i%c] = mat[i/n][i%n];
        }
        return ans;
    }
}
