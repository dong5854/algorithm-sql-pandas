import java.io.*;
import java.util.*;

public class BOJ2156 {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if( N == 1) {
            System.out.println(arr[1]);
            return;
        } else if (N == 2) {
            System.out.println(arr[1] + arr[2]);
            return;
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(arr[i] + arr[i-1] + dp[i-3], Math.max(arr[i]  + dp[i-2], dp[i-1]));
        }

        System.out.println(dp[N]);
    }
}