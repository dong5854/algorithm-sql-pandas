import java.io.*;
import java.util.*;

public class CODETREE점빼기 {

  static class Point implements Comparable<Point>{

    int x,y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point o) {
      int c = Integer.compare(this.x, o.x);
      if (c == 0) {
        return Integer.compare(this.y, o.y);
      }
      return c;
    }

    @Override
    public String toString() {
      return x + " " + y;
    }
  }
  public static void main(String[] args) throws Exception {
    int n, m;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    TreeSet<Point> set = new TreeSet<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      set.add(new Point(x, y));
    }

    for (int i = 0; i < m; i++) {
      int k = Integer.parseInt(br.readLine());
      Point p = set.higher(new Point(k, 0));
      if (p == null) {
        System.out.println("-1 -1");
      } else {
        System.out.println(p);
        set.remove(p);
      }
    }
    br.close();
  }
}
