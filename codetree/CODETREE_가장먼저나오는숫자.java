import java.io.*;
import java.util.*;

public class CODETREE_가장먼저나오는숫자 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr, target)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        
        int ans = -2;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] >= target) {
                if (arr[m] == target) ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans + 1;
    }
}