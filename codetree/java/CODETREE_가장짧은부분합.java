import java.util.*;
import java.io.*;

public class CODETREE_가장짧은부분합 {

    static int n, s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = Integer.MAX_VALUE;

        int sumVal = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while(j < n && sumVal < s) {
                sumVal += arr[j];
                j++;
            }

            if (sumVal >= s) {
                ans = Math.min(ans, j - i); 
            }

            sumVal -= arr[i];
        }

        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
        br.close(); 
    }
}