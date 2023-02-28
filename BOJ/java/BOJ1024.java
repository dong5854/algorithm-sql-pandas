import java.io.*;
import java.util.*;

public class BOJ1024 {
    static int N, L;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        input();
        for (int i = L; i <= 100; i++) {
            if (getAns(i)) {
                System.out.println(sb);
                return;
            }
        }

        System.out.println(-1);
    }


    static boolean getAns(int len) {
        find : for (int i = L; i <= len; i++) {
            if (i % 2 == 1) {   // 홀수 개일 때
                if (N % i == 0) {
                    int mid = N / i;
                    for (int val = mid - (i / 2); val <= mid + (i / 2); val++) {
                        if (val < 0) continue find;
                        sb.append(val).append(" ");
                    }
                    return true;
                }
            } else {    // 짝수 일때
                int midLeft = N / i;
                int midRight = midLeft + 1;
                if (N  % (midLeft+midRight) == 0) {
                    for (int val = midLeft - (i / 2) + 1; val <= midRight + (i / 2) - 1; val++) {
                        if (val < 0) continue find;
                        sb.append(val).append(" ");
                    }
                    return true;
                }
            }
        }
        return false;
    }


    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        br.close();
    }
}
