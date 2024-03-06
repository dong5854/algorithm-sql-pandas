import java.io.*;
import java.util.*;

public class BOJ13458 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] Ai = new int[N];
        for (int i = 0; i < N; i++) {
            Ai[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        br.close();

        long cnt = 0;

        for (int i = 0; i < N; i++) {
            Ai[i] -= B;
            cnt += 1;
            if (Ai[i] <= 0) continue;
            cnt += (Ai[i] / C);
            cnt += Ai[i] % C == 0 ? 0 : 1;
        }

        System.out.println(cnt);

    }
}
