import java.util.*;
import java.io.*;

public class CODETREE단어장 {
  public static void main(String[] args) throws Exception {
    Map<String, Integer> map = new TreeMap<>();
    StringBuilder sb = new StringBuilder();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 1; i <= n; i++) {
      String key = br.readLine();
      map.put(key, map.getOrDefault(key, 0) + 1);
    }

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
    }

    System.out.println(sb);

    br.close();
  }
}
/**
 * 2023-09-05
 */
// import java.util.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         Map<String, Integer> map = new TreeMap<>();
//         int n = Integer.parseInt(br.readLine());
//         for (int i = 0; i < n; i++) {
//             String word = br.readLine();
//             map.put(word, map.getOrDefault(word, 0) + 1);
//         }

//         StringBuilder sb = new StringBuilder();
//         for (String key : map.keySet()) {
//             sb.append(key).append(" ").append(map.get(key)).append("\n");
//         }

//         System.out.println(sb);

//         br.close();
//     }
// }