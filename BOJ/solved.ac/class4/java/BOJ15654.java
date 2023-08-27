import java.io.*;
import java.util.*;

public class BOJ15654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] ans = new int[M];
        boolean[] visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutation(arr, ans, visited, 0);
        br.close();
    }
    private static void permutation(int[] arr, int[] ans, boolean[] visited, int cnt) {
        if (cnt == ans.length) {
            StringBuilder sb = new StringBuilder();
            for (int a : ans) {
                sb.append(a).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            ans[cnt] = arr[i];
            permutation(arr, ans, visited, cnt + 1);
            visited[i] = false;
        }
    }
}
