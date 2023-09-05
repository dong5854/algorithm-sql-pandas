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
/**
 * 2023-09-05
 */
// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         Set<String> set = new HashSet<>();
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < n; i++) {
//             String[] command = br.readLine().split(" ");
//             switch(command[0]) {
//                 case "find":
//                     if (set.contains(command[1])) sb.append("true");
//                     else sb.append("false");
//                     sb.append("\n");
//                     break;
//                 case "add":
//                     set.add(command[1]);
//                     break;
//                 case "remove":
//                     set.remove(command[1]);
//                     break;
//             }
//         }

//         System.out.println(sb);
//         br.close();
//     }
// }