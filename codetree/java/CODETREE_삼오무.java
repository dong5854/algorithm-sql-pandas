import java.util.*;
import java.io.*;

public class CODETREE_삼오무 {

    private static int getNumOfNumbers(int num) {
        int mooCnt = num / 3 + num / 5 - num / 15;

        return num - mooCnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long l = 1;
        long r = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        while (l <= r) {
            int mid =(int)((l + r) / 2);
            if (getNumOfNumbers(mid) >= N) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(ans);

        br.close();
    }
}