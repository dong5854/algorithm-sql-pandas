import java.io.*;
import java.util.*;

public class CODETREE_괄호쌍만들어주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int[] close = new int[arr.length];
        boolean[] open = new boolean[arr.length];

        for (int i = arr.length - 2; i >= 0; i--) {
            close[i] = (arr[i] == ')' && arr[i+1] == ')') ? close[i+1] + 1 : close[i+1];
        }

        long ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '(' && arr[i-1] == '(') {
                ans += close[i];
            }
        }

        System.out.println(ans);

        br.close();
    }
}