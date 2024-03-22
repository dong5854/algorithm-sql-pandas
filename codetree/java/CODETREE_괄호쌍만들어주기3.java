import java.util.*;
import java.io.*;

public class CODETREE_괄호쌍만들어주기3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int cnt = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '(') continue;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == ')') cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
