import java.util.*;
import java.io.*;

public class CODETREEtreeset기본 {

  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    TreeSet<Integer> set = new TreeSet<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String command = st.nextToken();
      if (command.equals("add")) {
        int val = Integer.parseInt(st.nextToken());
        set.add(val);
      }

      if (command.equals("find")) {
        int val = Integer.parseInt(st.nextToken());
        if (set.contains(val)) {
          System.out.println("true");
        } else {
          System.out.println("false");
        }
      }

      if (command.equals("remove")) {
        int val = Integer.parseInt(st.nextToken());
        set.remove(val);
      }

      if (command.equals("lower_bound")) {
        int val = Integer.parseInt(st.nextToken());
        if (set.ceiling(val) == null) {
          System.out.println("None");
        } else {
          System.out.println(set.ceiling(val));
        }
      }

      if (command.equals("upper_bound")) {
        int val = Integer.parseInt(st.nextToken());
        if (set.higher(val) == null) {
          System.out.println("None");
        } else {
          System.out.println(set.higher(val));
        }
      }

      if (command.equals("largest")) {
        if (set.size() == 0) {
          System.out.println("None");
        } else {
          System.out.println(set.last());
        }
      }

      if (command.equals("smallest")) {
        if (set.size() == 0) {
          System.out.println("None");
        } else {
          System.out.println(set.first());
        }
      }
    }
  }
}