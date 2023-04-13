import java.io.*;
import java.util.*;

public class CODETREE서로다른숫자 {

  public static void main(String[] args) throws Exception {
    Set<Integer> set = new HashSet<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      set.add(num);
    }
    System.out.println(set.size());
    br.close();
  }
}