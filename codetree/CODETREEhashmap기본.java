import java.util.*;
import java.io.*;

public class CODETREEhashmap기본 {

  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String command = st.nextToken();
      if (command.equals("add")) {
        int key = Integer.parseInt(st.nextToken());
        int val = Integer.parseInt(st.nextToken());
        map.put(key, val);
      }

      if (command.equals("find")) {
        int key = Integer.parseInt(st.nextToken());
        if (map.containsKey(key)) {
          System.out.println(map.get(key));
        } else {
          System.out.println("None");
        }
      }
      if (command.equals("remove")) {
        int key = Integer.parseInt(st.nextToken());
        map.remove(key);
      }
    }
  }
}