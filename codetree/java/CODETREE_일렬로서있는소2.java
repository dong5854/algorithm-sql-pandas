import java.io.*;
import java.util.*;

public class CODETREE_일렬로서있는소2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cows = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (cows[j] <= cows[i]) continue;
                for (int k = j + 1; k < N; k++) {
                    if (cows[k] <= cows[j]) continue;
                    ans++;
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}
