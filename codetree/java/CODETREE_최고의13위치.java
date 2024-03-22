import java.io.*;
import java.util.*;

public class CODETREE_최고의13위치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        int ans = 0;
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int start = 0; start < N-2; start++) {
                ans = Math.max(ans, map[i][start] + map[i][start+1] + map[i][start+2]);
            }
        }

        System.out.println(ans);

        br.close();
    }
}