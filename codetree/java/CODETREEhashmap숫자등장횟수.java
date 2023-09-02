import java.util.*;
import java.io.*;

public class CODETREEhashmap숫자등장횟수 {

  public static void main(String[] args) throws Exception {

    Map<Integer, Integer> map = new HashMap<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < m; i++) {
      int num = Integer.parseInt(st.nextToken());
      System.out.print(map.getOrDefault(num, 0) + " ");
    }
  }
}

/**
 * 2023-09-02 다시
 */
// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());

//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < N; i++) {
//             int num = Integer.parseInt(st.nextToken());
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         StringBuilder sb = new StringBuilder();
//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < M; i++) {
//             int num = Integer.parseInt(st.nextToken());
//             sb.append(map.getOrDefault(num, 0));
//             sb.append(" ");
//         }
//         System.out.println(sb);
//         br.close();
//     }
// }