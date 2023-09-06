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
/**
 * 2023-09-07
 */
// import java.util.*;
// import java.io.*;

// public class Main {

//     static class Dot implements Comparable<Dot>{

//         int x;
//         int y;

//         public Dot(int x, int y) {
//             this.x = x;
//             this.y = y;
//         }

//         @Override
//         public int compareTo(Dot d) {
//             int c = Integer.compare(this.x, d.x);
//             if (c == 0) c = Integer.compare(this.y, d.y);
//             return c;
//         }

//         @Override
//         public String toString() {
//             return x + " " + y;
//         }
//     }

//     public static void main(String[] args) throws Exception {
//         TreeSet<Dot> set = new TreeSet<>();
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine(), " ");

//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());

//         for (int i = 0; i < n; i++) {
//             st = new StringTokenizer(br.readLine(), " ");
//             set.add(new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
//         }

//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < m; i++) {
//             st = new StringTokenizer(br.readLine(), " ");
//             Dot dot = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//             Dot close = set.higher(dot);
//             if (close == null) sb.append("-1 -1").append("\n");
//             else sb.append(close).append("\n");
//         }

//         System.out.println(sb);

//         br.close();
//     }
// }