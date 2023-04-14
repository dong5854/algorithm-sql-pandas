import java.io.*;
import java.util.*;

public class CODETREE친한점 {

  static class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
      int c = Integer.compare(this.x, o.x);
      if (c == 0) {
        c = Integer.compare(this.y, o.y);
      }
      return c;
    }
  }

  public static void main(String[] args) throws Exception {
    TreeSet<Pair> set = new TreeSet<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      set.add(new Pair(x, y));
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      Pair pair = set.ceiling(new Pair(x, y));
      if (pair == null) {
        System.out.println(-1 + " " + -1);
      } else {
        System.out.println(pair.x + " " + pair.y);
      }
    }

    br.close();
  }
}
