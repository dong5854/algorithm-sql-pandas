import java.io.*;
import java.util.*;

public class CODETREE앞에서부터삭제하기2 {

    static int n;

    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p) {
            return Integer.compare(this.idx, p.idx);
        }

        @Override
        public String toString() {
            return "idx : " + idx + " " + "val : " + val;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        TreeSet<Pair> set = new TreeSet<>(((a, b) -> {
            int c = Integer.compare(a.val, b.val);
            if (c == 0) c = Integer.compare(a.idx, b.idx);
            return c;
        }));

        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            Pair pair = new Pair(num, i);
            pq.add(pair);
            set.add(pair);
            sum += num;
        }

        double ans = 0;
        for (int k = 1; k <= n-2; k++) {
            Pair polled = pq.poll();
            set.remove(polled);
            sum -= polled.val;
            int temp = sum - set.first().val;
            ans = Math.max(ans, temp / (double) (pq.size() - 1));
        }

        System.out.printf("%.2f", ans);

        br.close();
    }
}