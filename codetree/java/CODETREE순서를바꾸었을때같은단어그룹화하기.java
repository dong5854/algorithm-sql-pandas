import java.io.*;
import java.util.*;

public class CODETREE순서를바꾸었을때같은단어그룹화하기 {

  static Map<String, Integer> group;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    group = new HashMap<>();

    for (int i = 0; i < n; i++) {
      // 소문자 0~25, 대문자 26~51
      int[] alpha = new int[52];
      String word = br.readLine();
      for (int idx = 0; idx < word.length(); idx++) {
        char c = word.charAt(idx);
        if (c >= 'a' && c <= 'z') {
          alpha[c - 'a'] += 1;
        } else {
          alpha[c - 'A' + 26] += 1;
        }
      }

      StringBuilder sb = new StringBuilder();
      for (int idx = 0; idx < alpha.length; idx++) {
        if (alpha[idx] == 0)
          continue;
        // 소문자
        if (idx >= 0 && idx <= 25) {
          char c = (char) (idx + 'a');
          sb.append(c).append(alpha[idx]);
        } else {
          char c = (char) (idx - 26 + 'A');
          sb.append(c).append(alpha[idx]);
        }
      }

      group.put(sb.toString(), group.getOrDefault(sb.toString(), 0) + 1);
    }

    int ans = 0;
    for (String key : group.keySet()) {
      if (ans < group.get(key)) {
        ans = group.get(key);
      }
    }

    System.out.println(ans);
    br.close();
  }
}
/**
 * 2021-09-04
 */
// import java.util.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         Map<String, Integer> map = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             List<Character> list = new ArrayList<>();
//             String word = br.readLine();
//             for (int c = 0; c < word.length(); c++) {
//                 list.add(word.charAt(c));
//             }
//             Collections.sort(list);
//             StringBuilder sb = new StringBuilder();
//             for (char c : list) {
//                 sb.append(c);
//             }
//             map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
//         }

//         int ans = 0;
//         for (int val : map.values()) {
//             ans = Math.max(ans, val);
//         }

//         System.out.println(ans);

//         br.close();
//     }
// }