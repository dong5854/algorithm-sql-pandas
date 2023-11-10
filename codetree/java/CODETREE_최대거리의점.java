import java.util.*;
import java.io.*;

public class CODETREE_최대거리의점 {

    static final int MAX_NUM = 200_000;

    static int n;
    static int m;
    static int[] arr;

    public static boolean isPossible(int dist) {
        int cnt = 1;
        int prevIdx = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[prevIdx] >= dist) {
                cnt++;
                prevIdx = i;
            }
        }

        return cnt >= m;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int l = 1;
        int r = MAX_NUM;
        int ans = 0;

        while(l <= r) {
            int m = (l + r) / 2;
            if (isPossible(m)) {
                l = m + 1;
                ans = m;
            } else {
                r = m - 1;
            }
        }        
        
        System.out.println(ans);

        br.close();
    }
}