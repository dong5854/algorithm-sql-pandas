import java.io.*;
import java.util.*;

public class CODETREE작지만큰숫자 {

  static int N, M;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    TreeSet<Integer> set = new TreeSet<>();
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      set.add(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < M; i++) {
      Integer t = Integer.parseInt(st.nextToken());
      Integer r = set.floor(t);
      if (r == null) {
        System.out.println("-1");
      } else {
        System.out.println(r);
        set.remove(r);
      }
    }
    br.close();
  }
}
