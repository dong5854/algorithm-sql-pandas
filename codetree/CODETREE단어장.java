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