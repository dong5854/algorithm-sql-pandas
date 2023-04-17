import java.io.*;
import java.util.*;

public class CODETREE최대숫자구하기 {

  static int n, m;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 1; i <= m; i++) {
      set.add(i);
    }

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      set.remove(num);
      System.out.println(set.last());
    }
    br.close();
  }
}
