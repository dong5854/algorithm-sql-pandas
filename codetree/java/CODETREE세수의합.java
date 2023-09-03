import java.io.*;
import java.util.*;

public class CODETREE세수의합 {

  static int ans;
  static int n, k;

  static int[] arr;
  static Map<Integer, Integer> map;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    map = new HashMap<>();

    ans = 0;

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    for (int i = 0; i < n; i++) {
      map.put(arr[i], map.get(arr[i]) - 1);
      for (int j = 0; j < i; j++) {
        if (map.containsKey(k - arr[i] - arr[j])) {
          ans += map.get(k - arr[i] - arr[j]);
        }
      }
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

//         List<Integer> list = new ArrayList<>();
//         Map<Integer, Integer> map = new HashMap<>();

//         int n = Integer.parseInt(st.nextToken());
//         int k = Integer.parseInt(st.nextToken());

//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < n; i++) {
//             int num = Integer.parseInt(st.nextToken());
//             map.put(num, map.getOrDefault(num, 0) + 1);
//             list.add(num);
//         }

//         int ans = 0;
//         for(int i = 0; i < n; i++) { // 첫 번째
//             int num1 = list.get(i);
//             map.put(num1, map.get(num1) - 1);
//             for (int j = 0; j < i; j++) { // 두 번째
//                 int num2 = list.get(j);
//                 if (map.containsKey(k - num1 - num2)) ans += map.get(k - num1 - num2);
//             }
//         }

//         System.out.println(ans);
//         br.close();
//     }
// }
