import java.util.*;
import java.io.*;

public class CODETREE_최소통과시간 {

    static int n;
    static int m;

    static int[] pipe;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pipe = new int[m];
        for (int i =0; i < m; i++) {
            pipe[i] = Integer.parseInt(br.readLine());
        }

        long l = 0;
        long r = Long.MAX_VALUE;
        long ans = Long.MAX_VALUE;

        while (l <= r) {
            long mid = (l + r) / 2;
            long passedCnt = 0;
            for (int p : pipe) {
                passedCnt += mid/p;
            }

            if (passedCnt >= n) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(ans);

        br.close();
    }
}