import java.io.*;
import java.util.*;

public class 세수의최대곱 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MIN_VALUE;
        Arrays.sort(arr);

        ans = Math.max(ans, arr[0] * arr[1] * arr[2]);
        ans = Math.max(ans, arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3]);
        ans = Math.max(ans, arr[arr.length - 1] * arr[0] * arr[1]);

        System.out.println(ans);

        br.close();
    }
}