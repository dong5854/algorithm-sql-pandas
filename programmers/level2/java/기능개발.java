import java.util.*;

class 기능개발 {
    
    class Task {
        int progress;
        int speed;
        
        public Task(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
        
        public boolean taskDone(int day) {
            if ((progress + speed * day) >= 100) return true;
            return false;
        }
    }
    
    public List<Integer> solution(int[] progresses, int[] speeds) {
        ArrayDeque<Task> queue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(new Task(progresses[i], speeds[i]));
        }
        
        List<Integer> answer = new ArrayList<>();
        int day = 1;
        while(!queue.isEmpty()) {
            int cnt = 0;
            while(!queue.isEmpty() && queue.peek().taskDone(day)) {
                cnt++;
                queue.poll();
            }
            day++;
            if (cnt > 0) answer.add(cnt);
        }

        return answer;
    }
}