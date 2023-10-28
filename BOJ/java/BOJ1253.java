import java.io.*;
import java.util.*;

public class BOJ1253 {
    public static void main(String[] args) throws Exception {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        br.close();

        // 조합
        int ans = 0;
        Arrays.sort(arr);
        for (int t = 0; t < N; t++) {
            long target = arr[t];
            int s = 0;
            int e = N - 1;
            while (s < e) {
                if (arr[s] + arr[e] == target) {
                    if (s != t && e != t) {
                        ans++;
                        break;
                    } else if (s == t) {
                        s++;
                    } else {
                        e--;
                    }
                } else if (arr[s] + arr[e] < target) {
                    s++;
                } else if (arr[s] + arr[e] > target) {
                    e--;
                }
            }
        }

        System.out.println(ans);
    }
}
