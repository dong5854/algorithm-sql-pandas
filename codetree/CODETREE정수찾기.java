import java.io.*;
import java.util.*;

public class CODETREE정수찾기 {

  public static void main(String[] args) throws Exception {
    Set<Integer> aSet = new HashSet<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      aSet.add(num);
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < m; i++) {
      if (aSet.contains(Integer.parseInt(st.nextToken()))) {
        System.out.println(1);
        continue;
      }
      System.out.println(0);
    }
    br.close();
  }
}