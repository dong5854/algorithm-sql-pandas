import java.io.*;
import java.util.*;

public class CODETREE_겹치지않는선분 {

    static int N;

    static class Segment implements Comparable<Segment> {
        int x1,x2;
        public Segment (int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
        @Override
        public int compareTo(Segment s) {
            return Integer.compare(this.x1, s.x1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Segment> list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            list.add(new Segment(x1, x2));
        }

        Collections.sort(list);

        int[] L = new int[N];
        int[] R = new int[N];

        L[0] = list.get(0).x2;
        for (int i = 1; i < N; i++) {
            L[i] = Math.max(L[i-1], list.get(i).x2);
        }

        R[N-1] = list.get(N-1).x2;
        for (int i = N-2; i >= 0; i--) {
            R[i] = Math.min(R[i+1], list.get(i).x2);
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            if (i > 0 && L[i-1] >= list.get(i).x2) continue;
            if (i < N-1 && R[i+1] <= list.get(i).x2) continue;
            ans++;
        }

        System.out.println(ans);

        br.close();
    }
}