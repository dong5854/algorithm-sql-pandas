import java.util.*;
import java.io.*;

public class CODETREE두수의합 {

  static long[] arr;
  static Map<Long, Integer> map;
  static int n, k;
  static int ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    ans = 0;
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new long[n];
    map = new HashMap<>();
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      long diff = k - arr[i];
      if (map.containsKey(diff)) {
        ans += map.get(diff);
      }

      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    System.out.println(ans);
  }
}
/**
 * 2021-09-03 다시 풀이
 */
// import java.util.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int n = Integer.parseInt(st.nextToken());
//         int k = Integer.parseInt(st.nextToken());

//         st = new StringTokenizer(br.readLine());
//         HashMap<Integer, Integer> map = new HashMap<>();
//         List<Integer> list = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             int num = Integer.parseInt(st.nextToken());
//             map.put(num, map.getOrDefault(num, 0) + 1);
//             list.add(num);
//         }
        
//         int ans = 0;
//         for (int num : list) {
//             if (map.containsKey(num)) map.put(num, map.get(num) - 1);
//             ans += map.getOrDefault(k - num, 0);
//         }
//         System.out.println(ans);
//         br.close();
//     }
// }