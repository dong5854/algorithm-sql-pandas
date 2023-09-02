import java.util.*;
import java.io.*;

public class CODETREE대칭차집합 {
  static int A;
  static int B;
  static Set<Integer> aSet = new HashSet<>();
  static Set<Integer> bSet = new HashSet<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine(), " ");
    for (int a = 0; a < A; a++) {
      aSet.add(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine(), " ");
    for (int b = 0; b < B; b++) {
      bSet.add(Integer.parseInt(st.nextToken()));
    }

    List<Integer> toRemove = new ArrayList<>();
    for (Integer a : aSet) {
      if (bSet.remove(a)) {
        toRemove.add(a);
      }
    }

    for (Integer r : toRemove) {
      aSet.remove(r);
    }

    System.out.println(aSet.size() + bSet.size());
    br.close();
  }
}
