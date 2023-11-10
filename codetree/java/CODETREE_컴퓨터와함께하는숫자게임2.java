import java.io.*;
import java.util.*;

public class CODETREE_컴퓨터와함께하는숫자게임2 {

    static long m;
    static long a,b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (long i = a; i <= b; i++) {
            int cnt = binarySearch(i);
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        }

        System.out.println(min + " " + max);

        br.close();
    }

    static int binarySearch(long target) {
        long l = 1;
        long r = m;

        int cnt = 0;

        while (l <= r) {
            cnt++;
            long m = (l + r) / 2;
            if (target < m) {
                r = m - 1;
            } else if (target > m) {
                l = m + 1;
            } else {
                break;   
            }
        }

        return cnt;
    }
}