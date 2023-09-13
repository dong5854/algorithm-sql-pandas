import java.io.*;
import java.util.*;

public class CODETREEk번째로작은쌍의합 {

    static int n,m,k;
    static int[] first;
    static int[] second;

    static class Pair implements Comparable<Pair> {

        int aIdx,bIdx;
        int a, b;

        public Pair(int aIdx, int bIdx) {
            this.aIdx = aIdx;
            this.bIdx = bIdx;
            this.a = first[aIdx];
            this.b = second[bIdx];
        }

        public int sum() {
            return a + b;
        }

        @Override
        public int compareTo(Pair p) {
            int c = Integer.compare(this.a + this.b , p.a + p.b);
            if (c == 0) c = Integer.compare(this.a, p.a);
            if (c == 0) c = Integer.compare(this.b, p.b);
            return c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        first = Arrays.stream(br.readLine().split(" ")).
        mapToInt(Integer::parseInt).
        sorted().toArray();

        second = Arrays.stream(br.readLine().split(" ")).
        mapToInt(Integer::parseInt).
        sorted().toArray();

        br.close();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int pollCnt = 0;
        for (int i = 0; i < first.length; i++) {
            pq.add(new Pair(i, 0));
        }

        while(k-->1) {
            Pair min = pq.poll();
            int aMinIdx = min.aIdx;
            int bMinIdx = min.bIdx;

            if (bMinIdx + 1 < second.length) {
                pq.add(new Pair(aMinIdx, bMinIdx + 1));
            }
        }

        System.out.println(pq.poll().sum());
        return;
    }
}