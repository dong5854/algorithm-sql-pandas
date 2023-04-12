import java.util.*;
import java.io.*;

public class CODETREE처음등장하는위치 {
  public static void main(String[] args) throws Exception {
    Map<Integer, Integer> map = new TreeMap<>();
    StringBuilder sb = new StringBuilder();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= n; i++) {
      map.putIfAbsent(Integer.parseInt(st.nextToken()), i);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
    }

    System.out.println(sb);

    br.close();
  }
}