import java.io.*;
import java.util.*;

public class CODETREE정수명령어 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      TreeSet<Integer> set = new TreeSet<>();
      int K = Integer.parseInt(br.readLine());
      for (int k = 0; k < K; k++) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        char command = st.nextToken().charAt(0);
        int val = Integer.parseInt(st.nextToken());
        if (command == 'I') {
          set.add(val);
        } else if (command == 'D' && val == 1) {
          if (set.size() == 0)
            continue;
          set.remove(set.last());
        } else {
          if (set.size() == 0)
            continue;
          set.remove(set.first());
        }
      }

      if (set.size() == 0) {
        System.out.println("EMPTY");
      } else {
        System.out.println(set.last() + " " + set.first());
      }
    }
    br.close();
  }
}
/**
 * 2023-09-07
 */
// import java.io.*;
// import java.util.*;
// import java.util.stream.*;

// public class Main {

//     static int T, k;

//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         T = Integer.parseInt(br.readLine());
//         StringBuilder sb = new StringBuilder();
//         for (int tc = 0; tc < T; tc++) {
//             k = Integer.parseInt(br.readLine());
//             TreeSet<Integer> set = new TreeSet<>();
//             for (int i = 0; i < k; i++) {
//                 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//                 String command = st.nextToken();
//                 int num = Integer.parseInt(st.nextToken());
//                 switch(command) {
//                     case "I":
//                         set.add(num);
//                         break;
//                     case "D":
//                         if (set.isEmpty()) break;
//                         else if (num == -1) set.remove(set.first());
//                         else set.remove(set.last());
//                         break;
//                     default:
//                         break;
//                 }
//             }
//             if (set.isEmpty()) sb.append("EMPTY");
//             else sb.append(set.last()).append(" ").append(set.first());
//             sb.append("\n");
//         }

//         System.out.println(sb);

//         br.close();
//     }
// }