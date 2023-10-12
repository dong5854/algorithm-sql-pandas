import java.io.*;
import java.util.*;

public class CODETREE_씨오더블유 {

    static int n;
    static int[] cl,wl,cr,wr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String line = br.readLine();

        cl = new int[n];
        cr = new int[n];
        wl = new int[n];
        wr = new int[n];

        if (line.charAt(0) == 'C') cl[0] = 1;
        if (line.charAt(n-1) == 'W') wr[n-1] = 1;

        for (int i = 1; i < n; i++) {
            char ch = line.charAt(i);
            cl[i] = cl[i-1] + (ch == 'C' ? 1 : 0);
        }

        for (int i = n-2; i >= 0; i--) {
            char ch = line.charAt(i);
            wr[i] = wr[i+1] + (ch == 'W' ? 1 : 0);
        }

        long ans = 0;
        for (int i = 1; i < n-1; i++) {
            if (line.charAt(i) == 'O')  {
                ans += cl[i] * wr[i];
            }
        }

        System.out.println(ans);

        br.close();
    }
}