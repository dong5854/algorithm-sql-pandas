import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1052 {

    static int N;
    static int K;
    public static void main(String[] args) throws Exception {
        getInput();
        int ans;

        for (ans = 0; ; ans++) {
            int bottleCnt = 0;
            int temp = N;

            while (temp != 0) {
                if (temp % 2 == 1) bottleCnt++;
                temp /= 2;
            }

            if (bottleCnt <= K) break;
            N++;
        }

        System.out.println(ans);
    }

    static void getInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        br.close();
    }
}
