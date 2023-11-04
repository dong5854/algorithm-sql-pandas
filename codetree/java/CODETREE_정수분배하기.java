import java.io.*;
import java.util.*;

public class CODETREE_정수분배하기 {

    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] list = new int[n];
        
        int s = 0;
        int e = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
            e = Math.max(list[i], e);
        }

        int ans = 0;
        while(s <= e) {
            int mid = (s + e) / 2;
            if (mid == 0) break;
            int cnt = 0;
            for (int val : list) {
                cnt += val / mid;
            }

            if (cnt >= m) {
                ans = Math.max(ans, mid);
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        System.out.println(ans);

        br.close();
    }
}