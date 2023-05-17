import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<int[]> stack = new ArrayDeque<>();   // [가격, 시점]
        for (int i = 0; i < prices.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new int[]{prices[i], i});
                continue;
            }
            while(!stack.isEmpty()) {
                if (stack.peek()[0] > prices[i]) {  // 가격이 떨어졌다면,
                    int[] popped = stack.pop(); // 꺼낸 후,
                    answer[popped[1]] = i - popped[1]; // 버틴 시간을 나타낸다.
                } else {
                    break;
                }
            }
            stack.push(new int[]{prices[i], i});
        }
        
        while(!stack.isEmpty()) {
            int[] popped = stack.pop(); // 꺼낸 후,
            answer[popped[1]] = (prices.length-1) - popped[1]; // 버틴 시간을 나타낸다.
        }
        
        return answer;
    }
}