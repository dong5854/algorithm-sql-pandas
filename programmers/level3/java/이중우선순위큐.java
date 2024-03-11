import java.util.*;

class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        // val, alive (0,1)
        PriorityQueue<int[]> minQueue = new PriorityQueue<>((o1,o2) -> Integer.compare(o1[0], o2[0]));
        PriorityQueue<int[]> maxQueue = new PriorityQueue<>((o1,o2) -> -Integer.compare(o1[0], o2[0]));
        
        for (String oper : operations) {
            StringTokenizer st = new StringTokenizer(oper, " ");
            char command = st.nextToken().charAt(0);
            int value = Integer.parseInt(st.nextToken());
            if (command == 'I') {
                int[] data = new int[]{value, 1};
                minQueue.offer(data);
                maxQueue.offer(data);
            }
            if (command == 'D') {
                if (!minQueue.isEmpty() && value == -1) {
                    int[] polled = minQueue.poll();
                    while (!minQueue.isEmpty() && polled[1] == 0) {
                        polled = minQueue.poll();
                    }
                    polled[1] = 0;
                } else if (!maxQueue.isEmpty() && value == 1){
                    int[] polled = maxQueue.poll();
                    while (!maxQueue.isEmpty() && polled[1] == 0) {
                        polled = minQueue.poll();
                    }
                    polled[1] = 0;
                }
            }
        }
        
        int minVal = Integer.MAX_VALUE;
        int maxVal = 0;
        while(!minQueue.isEmpty()) {
            int[] polled = minQueue.poll();
            if (polled[1] == 0) continue;
            minVal = Math.min(minVal, polled[0]);
            maxVal = Math.max(maxVal, polled[0]);
        }
        
        int[] ans = new int[2];
        ans[0] = maxVal;
        ans[1] = minVal == Integer.MAX_VALUE ? 0 : minVal;
        return ans;
    }
}