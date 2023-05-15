import java.util.*;

class Solution {    
    class Task implements Comparable<Task>{
        int startTime, taskTime;
        
        public Task (int startTime, int taskTime) {
            this.startTime = startTime;
            this.taskTime = taskTime;
        }
        
        @Override
        public int compareTo(Task o) {
            return Integer.compare(this.taskTime, o.taskTime);
        }
    }
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        ArrayDeque<Task> queue = new ArrayDeque<>();
        for(int[] j : jobs) {
            queue.offer(new Task(j[0], j[1]));
        }
        
        
        int curTime = 0; int totalWaitTime = 0;
        PriorityQueue<Task> pq = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            if (pq.isEmpty()) { // 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
                while (!queue.isEmpty() && queue.peek().startTime <= curTime) {
                    pq.offer(queue.poll());
                }
            }
            if (pq.isEmpty()) { // 처리할 작업이 없으면 시간 경과
                curTime++;
                continue;
            }
            while(!pq.isEmpty()) {  // 처리할 작업들 처리
                Task polled = pq.poll();
                curTime += polled.taskTime;
                totalWaitTime += curTime - polled.startTime;
                while (!queue.isEmpty() && queue.peek().startTime <= curTime) {
                    pq.offer(queue.poll());
                }
            }
        }
        return totalWaitTime / jobs.length;
    }
}