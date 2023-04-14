import java.io.*;
import java.util.*;

public class CODETREE정수명령어 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      TreeSet<Integer> set = new TreeSet<>();
      int K = Integer.parseInt(br.readLine());
      for (int k = 0; k < K; k++) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        char command = st.nextToken().charAt(0);
        int val = Integer.parseInt(st.nextToken());
        if (command == 'I') {
          set.add(val);
        } else if (command == 'D' && val == 1) {
          if (set.size() == 0)
            continue;
          set.remove(set.last());
        } else {
          if (set.size() == 0)
            continue;
          set.remove(set.first());
        }
      }

      if (set.size() == 0) {
        System.out.println("EMPTY");
      } else {
        System.out.println(set.last() + " " + set.first());
      }
    }
    br.close();
  }
}
