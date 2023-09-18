import java.util.*;
import java.io.*;

public class CODETREE정수N개의합 {

    static int  n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] origin = Arrays.stream(br.readLine().split(" ")).
        mapToInt(Integer::parseInt).
        toArray();
        int[] prefixSum = new int[origin.length+1];

        for (int i = 1; i <= origin.length; i++) {
            prefixSum[i] = origin[i-1] + prefixSum[i-1];
        }

        int ans = 0;
        for (int i = k; i < prefixSum.length; i++) {
            ans = Math.max(ans, prefixSum[i] - prefixSum[i-k]);
        }

        System.out.println(ans);

        br.close();
    }
}