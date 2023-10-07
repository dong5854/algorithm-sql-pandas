import java.io.*;
import java.util.*;

public class CODETREE_이상한폭탄 {

    static int N;
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> canExplode = new HashMap<>();
        int[] nums = new int[N];
        int ans = -1;
        for (int i = 0; i < K; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (canExplode.getOrDefault(nums[i], 0) > 0) ans = Math.max(ans, nums[i]);
            canExplode.put(nums[i], canExplode.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = K; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (canExplode.getOrDefault(nums[i], 0) > 0) ans = Math.max(ans, nums[i]);
            canExplode.put(nums[i], canExplode.getOrDefault(nums[i], 0) + 1);
            canExplode.put(nums[i-K], canExplode.get(nums[i-K]) - 1);
        }

        System.out.println(ans);

        br.close();
    }
}