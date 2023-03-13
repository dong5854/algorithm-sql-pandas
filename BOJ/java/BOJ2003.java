import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1535 {
    static int N;
    static int[] L;
    static int[] J;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        L = new int[N+1];
        J = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[100][N+1];
        for (int j = 1; j <= N; j++) {   // 사람 수
            for (int h = 1; h < 100; h++) { // 최대 체력은 100 이고 0이 되면 죽는다.
                if (h < L[j]) {
                    // 총 체력보다 소모 체력이 더 크면, 스킵
                    dp[h][j] = dp[h][j-1];
                    continue;
                }
                dp[h][j] = Math.max(dp[h][j-1], dp[h-L[j]][j-1] + J[j]);
            }
        }

        System.out.println(dp[99][N]);
        br.close();
    }
}
