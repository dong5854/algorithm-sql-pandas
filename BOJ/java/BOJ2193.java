import java.io.*;

public class BOJ2193 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1 || N == 2) {
            System.out.println(1);
            return;
        }


        long[][] dp = new long[N+1][2];

        // 1자리 수
        dp[1][0] = 0;   // 0으로 끝
        dp[1][1] = 1;   // 1로 끝
        // 2자리수
        dp[2][0] = 1;   // 0으로 끝
        dp[2][1] = 0;   // 1로 끝

        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
