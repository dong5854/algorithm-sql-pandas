import java.io.*;
import java.util.*;

public class CODETREE_최대직사각형의합 {
    
    static int n;
    static int[][] graph;
    static int[][] prefix;

    static int getSum(int x, int y, int sx, int sy) {
        return prefix[x][y] - prefix[x][sy-1] - prefix[sx-1][y] + prefix[sx-1][sy-1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).
            mapToInt(Integer::parseInt).
            toArray();
        }

        // 누적합 구하기
        prefix = new int[n+1][n+1];
        for(int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                prefix[r][c] = prefix[r-1][c] + prefix[r][c-1] - prefix[r-1][c-1] + graph[r-1][c-1];
            }
        }

        //최대값 구하기
        int[] dp = new int[n+1];
        int ans = Integer.MIN_VALUE;
        for(int r1 = 1; r1 <= n; r1++) {
            for (int r2 = r1; r2 <= n; r2++) {
                for (int c = 1; c <= n; c++) {
                    int val = getSum(r2, c, r1, c);
                    dp[c] = Math.max(val, dp[c-1] + val);
                }

                for (int i = 1; i <= n; i++) {
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        System.out.println(ans);

        br.close();
    }
}