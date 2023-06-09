import java.util.*;

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        
        // 현재 시간 기준
        int curTime = 0;
        // 나가는 시간
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for (int o : order) {
            // 나갈 음료수들은 나간다.
            while(!q.isEmpty() && q.peek() <= curTime) {
                q.poll();
            }
            
            // 제조중인 음료 추가
            if (q.isEmpty()) {
                q.add(curTime + menu[o]);
            } else {
                q.add(q.peekLast() + menu[o]);
            }
            
            // 최대 대기 획인
            answer = Math.max(answer, q.size());
            // 시간 경과
            curTime += k;
        }
        
        
        return answer;
    }
}