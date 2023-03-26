import java.util.*;

class 단속카메라 {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        for (int[] route : routes) {
            pq.add(route);
        }
        
        int ans = 0; int lastCam = Integer.MIN_VALUE;
        while(!pq.isEmpty()) {
            int[] polled = pq.poll();
            if (lastCam < polled[0]) {
                ans++;
                lastCam = polled[1];
            }
        }
        
        return ans;
    }
}