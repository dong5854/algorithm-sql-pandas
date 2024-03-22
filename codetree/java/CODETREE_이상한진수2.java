import java.io.*;
import java.util.*;

public class CODETREE_이상한진수2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        char[] Ns = new char[N.length()];
        for (int i = 0; i < N.length(); i++) {
            Ns[i] = N.charAt(i);
        }

        boolean changed = false;

        for (int i = 0; i < Ns.length; i++) {
            if (Ns[i] == '0') {
                changed = true;
                Ns[i] = '1';
                break;
            }
        }

        if(!changed) {
            Ns[Ns.length - 1] = '0';
        }

        int ans = 0;
        for (int i = Ns.length - 1; i >= 0; i--) {
            if (Ns[i] == '0') continue;
            ans += (int) Math.pow(2, Ns.length - i - 1);
            Math.pow(2, i);
        }

        System.out.println(ans);

        br.close();
    }
}