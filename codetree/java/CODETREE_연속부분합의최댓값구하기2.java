import java.io.*;
import java.util.*;

public class CODETREE_연속부분합의최댓값구하기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int ans = Integer.MIN_VALUE;
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
            ans = Math.max(ans, sum);
            if (sum < 0) sum = 0;
        }

        System.out.println(ans);

        br.close();
    }
}