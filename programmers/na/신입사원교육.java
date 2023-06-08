import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : ability) {
            pq.add(a);
        }
        
        for (int i = 0; i < number; i++) {
            int o = pq.poll();
            int t = pq.poll();
            int sum = o + t;
            pq.add(sum);
            pq.add(sum);
        }
        
        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        
        return ans;
    }
}