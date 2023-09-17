import java.io.*;
import java.util.*;

public class CODETREE연속한K개의숫자 {

    static int N,K,B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        int[] prefixSum = new int[N+1];
        for(int i = 0; i < B; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 1; i <= N; i++) {
            if (set.contains(i)) prefixSum[i] = prefixSum[i-1];
            else prefixSum[i] = prefixSum[i-1] + 1;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= N-K; i++) {
            ans = Math.min(ans, K - (prefixSum[i+K] - prefixSum[i]));
        }

        System.out.println(ans);

        br.close();
    }
}