import java.util.*;
import java.io.*;

public class CODETREEhashmap숫자등장횟수 {

  public static void main(String[] args) throws Exception {

    Map<Integer, Integer> map = new HashMap<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < m; i++) {
      int num = Integer.parseInt(st.nextToken());
      System.out.print(map.getOrDefault(num, 0) + " ");
    }
  }
}