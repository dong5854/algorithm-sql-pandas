import java.io.*;
import java.util.*;

public class CODETREE_동전더하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            ans += k / coins[i];
            k %= coins[i];
        }

        System.out.println(ans);

        br.close();
    }
}