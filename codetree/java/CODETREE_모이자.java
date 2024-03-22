import java.io.*;
import java.util.*;

public class CODETREE_모이자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] houses = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int dist = Math.abs(i - j) * houses[j];
                sum += dist;
            }
            ans = Math.min(ans, sum);
        }

        System.out.println(ans);

        br.close();
    }
}
