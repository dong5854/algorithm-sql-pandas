import java.io.*;
import java.util.*;

public class CODETREE_최대구간의크기 {

    static int n;

    static class Point implements Comparable<Point> {

        int idx;
        int x;
        int val;

        public Point(int idx, int x, int val) {
            this.idx = idx;
            this.x = x;
            this.val = val;
        }

        @Override
        public int compareTo(Point p) {
            return Integer.compare(this.x, p.x);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            points.add(new Point(i, s, 1));
            points.add(new Point(i, e, -1));
        }
        Collections.sort(points);

        HashSet<Integer> segs = new HashSet<>();
        int ans = 0;
        int startX = -1;
        for (int i = 0; i < points.size(); i++) {
            int x = points.get(i).x;
            int val = points.get(i).val;
            int idx = points.get(i).idx;

            if(val == 1) {
                if(segs.size() == 0)
                    startX = x;    
                
                segs.add(idx);
            }

            else {
                segs.remove(idx);

                if(segs.size() == 0) {
                    int endX = x;
                    ans = Math.max(ans, endX - startX);
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}