import java.io.*;
import java.util.*;

public class BOJ2003 {
    static int N, M;
    static int[] A;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0, sum = A[0];
        int l = 0,r = 0;
        while (true) {
            if (sum == M) {
                cnt++;
                r++;
                if (r >= N) break;
                sum += A[r];
            } else if (l == r || sum < M) {
                r++;
                if (r >= N) break;
                sum += A[r];
            } else {
                sum -= A[l];
                l++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
