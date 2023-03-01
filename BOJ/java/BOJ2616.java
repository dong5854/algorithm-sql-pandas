import java.io.*;
import java.util.*;

public class BOJ2616 {

    static int N;
    static int[] sum;
    static int[][] dp;
    static int size;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sum = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken()); // 누적합
        }

        size = Integer.parseInt(br.readLine());
        dp = new int[4][N+1];
        for (int i = 1; i <= 3; i++) {
            for (int j = i *size; j <=N ; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-size] + (sum[j] - sum[j-size]));
            }
        }

        System.out.println(dp[3][N]);
    }
}
