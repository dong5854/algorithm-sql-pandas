import java.io.*;
import java.util.*;

public class CODETREE낮은지점들 {

  static Map<Integer, Integer> points;
  static int N;

  static public void main(String[] args) throws Exception {
    points = new HashMap<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      points.putIfAbsent(x, y);
      if (points.get(x) > y) {
        points.put(x, y);
      }
    }

    long ans = 0;
    for (Integer x : points.keySet()) {
      ans += points.get(x);
    }

    System.out.println(ans);
    br.close();
  }
}
/**
 * 2023-09-04
 */
// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             int x = Integer.parseInt(st.nextToken());
//             int y = Integer.parseInt(st.nextToken());
//             if (!map.containsKey(x)) map.put(x, y);
//             else if (map.get(x) > y) map.put(x, y);
//         }

//         long ans = 0;
//         for (int val : map.values()) {
//             ans += val;
//         }

//         System.out.println(ans);
//         br.close();
//     }
// }