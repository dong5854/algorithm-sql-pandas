import java.util.*;

class 더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int cnt = 0;
        
        while (pq.peek() < K) {
            cnt++;
            int first = pq.poll();
            if (pq.isEmpty()) return -1;
            int second = pq.poll();
            pq.offer(first + second * 2);
        }
        
        return cnt;
    }
}