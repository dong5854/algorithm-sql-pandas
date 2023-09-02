import java.util.*;
import java.io.*;

public class CODETREEhashset기본 {

  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    Set<Integer> set = new HashSet<>();

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
    }
  }
}