import java.io.*;
import java.util.*;

public class CODETREE특별한문자 {
  public static void main(String[] args) throws Exception {

    Map<Character, Integer> map = new HashMap<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String word = br.readLine();
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    br.close();

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (map.get(c) == 1) {
        System.out.println(c);
        return;
      }
    }

    System.out.println("None");
  }
}
/**
 * 2021-05-21 다시풀기
 */
// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String word = br.readLine();

//         Map<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < word.length(); i++) {
//             map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
//         }
//         br.close();
//         for (int i = 0; i < word.length(); i++) {
//             if (map.get(word.charAt(i)) == 1) {
//                 System.out.println(word.charAt(i));
//                 return;
//             }
//         }
//         System.out.println("None");
//     }
// }
