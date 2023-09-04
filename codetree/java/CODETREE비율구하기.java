import java.io.*;
import java.util.*;

public class CODETREE비율구하기 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Map<String, Integer> map = new TreeMap<>();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String key = br.readLine();
      map.put(key, map.getOrDefault(key, 0) + 1);
    }

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      sb.append(entry.getKey()).append(" ").append(String.format("%.4f", ((double) entry.getValue() / n) * 100))
          .append("\n");
    }

    System.out.println(sb);
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
//         Map<String, Integer> map = new TreeMap<>();
//         for (int i = 0; i < n; i++) {
//             String word = br.readLine();
//             map.put(word, map.getOrDefault(word, 0) + 1);
//         }

//         for (String word : map.keySet()) {
//             System.out.printf("%s %.4f\n", word, (map.get(word) / (double) n) * 100);
//         }
//         br.close();
//     }
// }