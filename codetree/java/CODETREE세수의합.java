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
