import java.util.*;
import java.io.*;

public class CODETREE데이터비교 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    Set<Integer> set = new HashSet<>();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      set.add(Integer.parseInt(st.nextToken()));
    }
    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < m; i++) {
      if (set.contains(Integer.parseInt(st.nextToken()))) {
        sb.append(1).append(" ");
      } else {
        sb.append(0).append(" ");
      }
    }
    System.out.println(sb);
    br.close();
  }
}
/**
 * 2023-09-05
 */
// import java.io.*;
// import java.util.*;
// import java.util.stream.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         Set<Integer> set = Arrays.
//         stream(br.readLine().split(" ")).
//         map(Integer::parseInt).
//         collect(Collectors.toCollection(HashSet::new));
        
//         int m = Integer.parseInt(br.readLine());
//         StringBuilder sb = new StringBuilder();
//         Arrays.stream(br.readLine().split(" ")).
//             map(Integer::parseInt).
//             forEach(x -> {
//                 if (set.contains(x)) sb.append(1).append(" ");
//                 else sb.append(0).append(" ");
//             });

//         System.out.println(sb);
//         br.close();
//     }
// }