import java.util.*;
import java.io.*;

public class CODETREE_마라톤중간에택시타기 {

    static int N;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distanceWith(Point p) {
            return (int)(Math.abs(this.x - p.x) + Math.abs(this.y - p.y));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        for (int i = 0 ; i< n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        int[] l = new int[n];
        int[] r = new int[n];

        for (int i = 1; i < n; i++) {
            l[i] = points[i].distanceWith(points[i-1]) + l[i-1];
        }

        for (int i = n-2; i >= 0; i--) {
            r[i] = points[i].distanceWith(points[i+1]) + r[i+1];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n-1; i++) {
            int distance = l[i-1] + r[i+1] + points[i-1].distanceWith(points[i+1]);
            ans = Math.min(ans, distance);
        }

        System.out.println(ans);

        br.close();
    }
}