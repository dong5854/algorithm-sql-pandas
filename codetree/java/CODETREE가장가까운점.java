import java.io.*;
import java.util.*;

public class CODETREE가장가까운점 {

    static class Pair implements Comparable<Pair>{

        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            int c =  Integer.compare((Math.abs(this.x) + Math.abs(this.y)), (Math.abs(p.x) + Math.abs(p.y)));
            if (c == 0) c = Integer.compare(this.x, p.x);
            if (c == 0) c = Integer.compare(this.y, p.y);
            return c;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Pair(x,y));
        }
        for (int i = 0; i < m; i++) {
            Pair polled = pq.poll();
            pq.add(new Pair(polled.x + 2, polled.y + 2));
        }

        System.out.println(pq.poll());
        br.close();
    }
}