class 산모양타일링 {

    static final int MOD = 10007;

    public int solution(int n, int[] tops) {
        // [마지막이 삼각형, 마지막이 마름모]
        int[][] dp = new int[n][2];

        if (tops[0] == 1) {
            dp[0][0] = 3;
            dp[0][1] = 1;
        } else {
            dp[0][0] = 2;
            dp[0][1] = 1;
        }

        for (int i = 1; i < n; i++) {
            int endTri = dp[i-1][0];
            int endDia = dp[i-1][1];
            if (tops[i] == 1) {
                dp[i][0] = ((endTri + endDia) * 2 + endTri) % MOD; // 마지막 삼각형
                dp[i][1] = (endTri + endDia) % MOD; // 마지막 다이아
            } else {
                dp[i][0] = (endTri + endDia + endTri) % MOD; // 마지막 삼각형
                dp[i][1] = (endTri + endDia) % MOD; // 마지막 다이아
            }
        }

        return (dp[n-1][0] + dp[n-1][1]) % MOD;
    }
}