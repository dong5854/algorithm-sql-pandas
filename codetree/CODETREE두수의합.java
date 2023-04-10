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