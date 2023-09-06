import java.io.*;
import java.util.*;

public class CODETREE정수찾기 {

  public static void main(String[] args) throws Exception {
    Set<Integer> aSet = new HashSet<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      aSet.add(num);
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < m; i++) {
      if (aSet.contains(Integer.parseInt(st.nextToken()))) {
        System.out.println(1);
        continue;
      }
      System.out.println(0);
    }
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
//         br.readLine();
//         Set<Integer> set = Arrays.stream(br.readLine().split(" ")).
//                             map(Integer::parseInt).
//                             collect(Collectors.toCollection(HashSet::new));
//         br.readLine();

//         StringBuilder sb = new StringBuilder();
//         Arrays.stream(br.readLine().split(" ")).
//             map(Integer::parseInt).
//             forEach(x -> {
//                 if (set.contains(x)) sb.append(1).append("\n");
//                 else sb.append(0).append("\n");
//             });

//         System.out.println(sb);

//         br.close();
//     }
// }