import java.io.*;
import java.util.*;

public class CODETREE_구간트리의합 {

    static int N;

    static class Point implements Comparable<Point> {

        int x;
        int val;
        int idx;

        Point(int x, int val, int idx) {
            this.x = x;
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p) {
            int c = Integer.compare(this.x, p.x);
            if (c == 0) c = Integer.compare(this.val, p.val);
            if (c == 0) c = Integer.compare(this.idx, p.idx);
            return c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        TreeSet<Point> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            set.add(new Point(s, 1, i));
            set.add(new Point(e, -1, i));
        }

        long curX = 0;
        long curVal = 0;
        long ans = 0;
        for (Point p : set) {
            if (curVal == 0) curX = p.x;
            curVal += p.val;
            if (curVal == 0) {
                ans += p.x - curX;
            }
        }

        System.out.println(ans);
        
        br.close();
    }
}