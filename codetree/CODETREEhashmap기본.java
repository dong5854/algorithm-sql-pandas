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

/**
 * 2023-09-03 다시
 */
// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         HashMap<String, String> map = new HashMap<>();
//         StringBuilder sb = new StringBuilder();
//         int tc = Integer.parseInt(br.readLine()); 
//         for (int t = 0; t < tc; t++) {
//             String[] line = br.readLine().split(" ");
//             switch (line[0]) {
//                 case "add":
//                     map.put(line[1], line[2]);
//                     break;
//                 case "find":
//                     if (map.containsKey(line[1])) {
//                         sb.append(map.get(line[1]));
//                     } else {
//                         sb.append("None");
//                     }
//                     sb.append("\n");
//                     break;
//                 case "remove":
//                     map.remove(line[1]);
//             }
//         }
//         System.out.println(sb);
//         br.close();
//     }
// }