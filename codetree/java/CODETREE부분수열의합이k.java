import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CODETREE부분수열의합이k {

    static int n,k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] origin = Arrays.stream(br.readLine().split(" ")).
        mapToInt(Integer::parseInt).
        toArray();

        int[] prefixSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + origin[i-1];
        }

        int cnt = 0;
        for (int s = 1; s <= n; s++) {
            for (int e = s; e <= n; e++) {
                if (prefixSum[e]- prefixSum[s-1] == k) cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}