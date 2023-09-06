import java.io.*;
import java.util.*;

public class CODETREE숫자빠르게찾기2 {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    TreeSet<Integer> set = new TreeSet<>();
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      set.add(Integer.parseInt(st.nextToken()));
    }

    for (int i = 0; i < m; i++) {
      int val = Integer.parseInt(br.readLine());
      Integer ceil = set.ceiling(val);
      if (ceil != null) {
        sb.append(ceil).append("\n");
      } else {
        sb.append(-1).append("\n");
      }
    }

    System.out.println(sb);
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
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());

//         TreeSet<Integer> set = Arrays.stream(br.readLine().split(" ")).
//         map(Integer::parseInt).
//         collect(Collectors.toCollection(TreeSet::new));

//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < m; i++) {
//             int num = Integer.parseInt(br.readLine());
//             if (set.ceiling(num) == null) sb.append(-1).append("\n");
//             else sb.append(set.ceiling(num)).append("\n");
//         }

//         System.out.println(sb);

//         br.close();
//     }
// }