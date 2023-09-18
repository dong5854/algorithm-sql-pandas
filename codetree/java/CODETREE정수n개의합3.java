import java.io.*;
import java.util.*;

public class CODETREE정수n개의합3 {

    static int n,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] origin = new int[n][];
        for (int i = 0; i < n; i++) {
            origin[i] = Arrays.stream(br.readLine().split(" ")).
            mapToInt(Integer::parseInt).
            toArray();
        }

        int[][] prefixSum = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1] + origin[i-1][j-1]; 
            }
        }

        int ans = 0;
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= n; j++) {
                ans = Math.max(ans, prefixSum[i][j] - prefixSum[i][j-k] - prefixSum[i-k][j] + prefixSum[i-k][j-k]);
            }
        }

        System.out.println(ans);

        br.close();
    }
}