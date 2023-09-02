import java.io.*;
import java.util.*;

public class CODETREEtop_k_숫자 {

  static int n, k;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    TreeSet<Integer> set = new TreeSet<>();
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      set.add(Integer.parseInt(st.nextToken()));
    }

    Integer val = set.last();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < k; i++) {
      sb.append(val).append(" ");
      val = set.lower(val);
    }
    System.out.println(sb);
    br.close();
  }
}
