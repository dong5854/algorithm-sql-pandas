import java.io.*;
import java.util.*;

public class CODETREETreeMap {
  public static void main(String[] args) throws Exception {
    Map<Integer, Integer> map = new TreeMap<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String command = st.nextToken();
      if (command.equals("add")) {
        int key = Integer.parseInt(st.nextToken());
        int val = Integer.parseInt(st.nextToken());
        map.put(key, val);
      } else if (command.equals("find")) {
        int key = Integer.parseInt(st.nextToken());
        if (!map.containsKey(key)) {
          System.out.println("None");
        } else {
          System.out.println(map.get(key));
        }
      } else if (command.equals("remove")) {
        int key = Integer.parseInt(st.nextToken());
        map.remove(key);
      } else {
        if (map.isEmpty()) {
          System.out.println("None");
          continue;
        }
        for (Integer key : map.keySet()) {
          System.out.print(map.get(key) + " ");
        }
        System.out.println();
      }
    }
  }
}
