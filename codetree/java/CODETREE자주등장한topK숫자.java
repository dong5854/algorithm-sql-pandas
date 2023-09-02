import java.util.*;
import java.io.*;

public class CODETREE자주등장한topK숫자 {
  public static void main(String[] args) throws Exception {
    Map<Integer, Integer> map = new HashMap<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    // 값, 횟수
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
      int c = -Integer.compare(o1[1], o2[1]);
      if (c == 0)
        c = -Integer.compare(o1[0], o2[0]);
      return c;
    });

    for (Integer key : map.keySet()) {
      pq.add(new int[] { key, map.get(key) });
    }

    for (int i = 0; i < k; i++) {
      System.out.print(pq.poll()[0] + " ");
    }
  }
}