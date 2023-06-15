class Solution {
    public int ways(String[] pizza, int k) {
        int R = pizza.length, C = pizza[0].length();
        int[][] apples = new int[R+1][C+1];
        int[][][] dp = new int[k][R][C];

        for (int r = R-1; r >= 0; r--) {
            for (int c = C-1; c >= 0; c--) {
                apples[r][c] = (pizza[r].charAt(c) == 'A' ? 1 : 0) + apples[r+1][c] + apples[r][c+1] - apples[r+1][c+1];
                dp[0][r][c] = apples[r][c] > 0 ? 1 : 0;
            }
        }

        final int mod = 1000000007;

        for (int remain = 1; remain < k; remain++) {
            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                    for (int nRow = row + 1; nRow < R; nRow++) {
                        if (apples[row][col] - apples[nRow][col] > 0) {
                            dp[remain][row][col] += dp[remain - 1][nRow][col];
                            dp[remain][row][col] %= mod;
                        }
                    }

                    for (int nCol = col + 1; nCol < C; nCol++) {
                        if (apples[row][col] - apples[row][nCol] > 0) {
                            dp[remain][row][col] += dp[remain - 1][row][nCol];
                            dp[remain][row][col] %= mod;
                        }
                    }
                }
            }   
        }
        return dp[k-1][0][0];
    }
}