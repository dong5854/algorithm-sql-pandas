import java.io.*;
import java.util.*;

public class CODETREE_구간외최대숫자 {

    static int n, q;
    static int[] origin;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        origin = Arrays.stream(br.readLine().split(" ")).
        mapToInt(Integer::parseInt).
        toArray();

        int[] l = new int[n];
        l[0] = origin[0];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(l[i-1], origin[i]);
        }

        int[] r = new int[n];
        r[n-1] = origin[n-1];
        for (int i = n-2; i >= 0; i--) {
            r[i] = Math.max(r[i+1], origin[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken()) - 2;
            int right = Integer.parseInt(st.nextToken());
            int ans = 0;
            if (left >= 0) ans = Math.max(ans, l[left]);
            if (right < n) ans = Math.max(ans, r[right]);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}