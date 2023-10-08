import java.io.*;
import java.util.*;

public class CODETREE_구간의합이같게나누기 {

    static int n;
    static int target;
    static int[] original;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        original = Arrays.stream(br.readLine().split(" ")).
        mapToInt(Integer::parseInt).
        toArray();

        int sum = Arrays.stream(original).sum();

        if (sum % 4 != 0) {
            System.out.println(0);
            return;
        }

        target = sum / 4;

        int[] l = new int[n];
        l[0] = 0;
        int tempSum = original[0];
        int cnt = (tempSum == target) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            tempSum += original[i];
            if (tempSum == target * 2) {
                l[i] = cnt;
            }
            if (tempSum == target) cnt++;
        }

        int[] r = new int[n];
        r[n-1] = 0;
        tempSum = original[n-1];
        cnt = (tempSum == target) ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            tempSum += original[i];
            if (tempSum == target * 2) {
                r[i] = cnt;
            }
            if (tempSum == target) cnt++;
        }
    
        long ans = 0;
        for (int i = 1; i < n-1; i++) {
            ans += (long) l[i] * r[i+1];
        }
        
        System.out.println(ans);

        br.close();
    }
}