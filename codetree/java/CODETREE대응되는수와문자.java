import java.util.*;
import java.io.*;

public class CODETREE대응되는수와문자 {
    public static void main(String[] args) throws Exception {
        int num = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> mapTwo = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, ++num);
            mapTwo.put(num, s);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            Integer val = map.get(s);
            if (val == null) {
                sb.append(mapTwo.get(Integer.parseInt(s)));
            } else {
                sb.append(val);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}