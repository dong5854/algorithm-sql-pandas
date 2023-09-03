import java.io.*;
import java.util.*;

public class CODETREE가장많은데이터 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String color = br.readLine();
            map.put(color, map.getOrDefault(color, 0) + 1);
        }

        int ans = 0;
        for (int val : map.values()) {
            ans = Math.max(ans, val);
        }

        System.out.println(ans);

        br.close();
    }
}