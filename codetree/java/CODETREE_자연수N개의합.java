import java.io.*;

public class CODETREE_자연수N개의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        long min = 1;
        long max = s;
        long ans = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;
            for (int i = 0; i <= mid; i++) {
                sum += i;
            }

            if (sum <= s) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(ans);

        br.close();
    }
}