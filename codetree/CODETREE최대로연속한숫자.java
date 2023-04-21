import java.io.*;
import java.util.*;

public class CODETREE최대로연속한숫자 {

  static int N, M;

  static class Section implements Comparable<Section> {
    int start, end;
    int len;

    public Section(int start, int end) {
      this.start = start;
      this.end = end;
      this.len = end - start + 1;
    }

    @Override
    public int compareTo(Section o) {
      int c = Integer.compare(this.len, o.len);
      if (c == 0)
        c = Integer.compare(this.start, o.start);
      if (c == 0)
        c = Integer.compare(this.end, o.end);
      return c;
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    TreeSet<Integer> points = new TreeSet<>();
    points.add(-1);
    points.add(N + 1);
    TreeSet<Section> set = new TreeSet<>();
    set.add(new Section(0, N));

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < M; i++) {
      int num = Integer.parseInt(st.nextToken());
      int lowerBound = points.lower(num) + 1;
      int uppperBound = points.higher(num) - 1;
      set.remove(new Section(lowerBound, uppperBound));

      set.add(new Section(lowerBound, num - 1));
      set.add(new Section(num + 1, uppperBound));
      points.add(num);
      System.out.println(set.last().len);
    }

    br.close();
  }
}