import java.io.*;
import java.util.*;

public class CODETREE가까운숫자 {

  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    TreeSet<Integer> set = new TreeSet<>();
    set.add(0);
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      Integer lower = set.lower(num);
      Integer higher = set.higher(num);
      if (lower != null) {
        int diff = num - lower;
        if (ans > diff) {
          ans = diff;
        }
      }
      if (higher != null) {
        int diff = higher - num;
        if (ans > diff) {
          ans = diff;
        }
      }
      set.add(num);
      System.out.println(ans);
    }
    br.close();
  }
}
