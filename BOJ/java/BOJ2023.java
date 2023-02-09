import java.io.*;
import java.util.*;

public class BOJ2023 {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        permutation(0, 0);

        System.out.println(sb.toString());
        br.close();
    }

    static void permutation (int cnt, int num) {
        if (cnt == N) {
            if (isPrime(num)) sb.append(num).append("\n");
            return;
        }

        for (int i = 0; i <=9; i++) {
            if (isPrime(num*10+i)) permutation(cnt + 1, num*10+i);
        }
    }

    static boolean isPrime(int num) {
        if (num == 1 || num == 0) return false;
        for(int i = 2; i*i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
