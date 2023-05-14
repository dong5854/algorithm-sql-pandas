import java.util.*;

class Solution {
    class Document implements Comparable<Document> {
        int priority;
        boolean isTarget;
        
        public Document(int priority, boolean isTarget) {
            this.priority = priority;
            this.isTarget = isTarget;
        }
        
        @Override
        public int compareTo(Document o) {
            return Integer.compare(this.priority, o.priority);
        }
    }
    
    public int solution(int[] priorities, int location) {
        ArrayDeque<Document> queue = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int loc = 0; loc < priorities.length; loc++) {
            queue.offer(new Document(priorities[loc], loc == location));
            pq.offer(priorities[loc]);
        }
        
        int cnt = 0;
        while (!queue.isEmpty()) {
            Document polled = queue.poll();
            if (polled.priority == pq.peek()) {
                cnt++;
                pq.poll();
                if (polled.isTarget) return cnt;
            } else {
                queue.offer(polled);
            }
        }
        return -1;
    }
}