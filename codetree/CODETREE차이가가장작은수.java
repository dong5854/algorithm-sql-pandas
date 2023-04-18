import java.io.*;
import java.util.*;

public class CODETREE차이가가장작은수 {
  static int n, m;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    TreeSet<Integer> set = new TreeSet<>();
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      Integer bigger = set.ceiling(num + m);
      Integer smaller = set.floor(num - m);
      if (bigger != null && ans > (bigger - num)) {
        ans = (bigger - num);
      }
      if (smaller != null && ans > (num - smaller)) {
        ans = (num - smaller);
      }
      set.add(num);
    }
    if (ans == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(ans);
    }
    br.close();
  }
}