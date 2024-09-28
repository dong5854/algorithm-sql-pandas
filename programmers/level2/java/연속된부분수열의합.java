import java.util.*;

class 연속된부분수열의합 {

    class Pair implements Comparable<Pair> {

        int start;
        int end;
        int len;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
            this.len = end-start;
        }

        @Override
        public int compareTo(Pair pair) {
            int c = Integer.compare(this.len, pair.len);
            if (c == 0) c = Integer.compare(this.start, pair.start);
            return c;
        }

    }


    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int val = sequence[start];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        while(start <= end && end < sequence.length) {
            if (val == k) {
                pq.add(new Pair(start, end));
                end++;
                if (end == sequence.length) break;
                val += sequence[end];
            }
            else if (val > k) {
                val -= sequence[start];
                start++;
                if (start > end) break;
            } else if (val < k){
                end++;
                if (end == sequence.length) break;
                val += sequence[end];
            }
        }

        Pair ans = pq.poll();

        return new int[]{ans.start, ans.end};
    }
}