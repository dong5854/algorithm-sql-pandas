import java.util.*;
class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<int[]> trucks = new ArrayDeque<>();
        int time = 1;       // 현재 시간
        int curWeight = 0;  // 현재 다리가 받치고 있는 무게
        for (int truck : truck_weights) {
            while (weight < curWeight + truck || trucks.size() == bridge_length) { // 트럭이 더 올라올 수 있을 때까지 큐에서 제거
                int[] arrived = trucks.poll(); // 트럭제거
                curWeight -= arrived[0]; // 내려온 트럭의 무게 차감
                time = arrived[1] + bridge_length;   // 현재 시간은 트럭이 진입 시간 + 다리의 길이
            }
            trucks.offer(new int[]{truck, time}); // 트럭 무게, 다리 진입 시간
            curWeight += truck; // 현재 다리가 받치고 있는 무게 추가
            time++; // 현재 시간 1초 지남
            if (trucks.peek()[1] + bridge_length == time) {
                int[] arrived = trucks.poll(); // 트럭제거
                curWeight -= arrived[0]; // 내려온 트럭의 무게 차감
            }
        }
        
        while (!trucks.isEmpty()) {
            int[] arrived = trucks.poll();
            time = arrived[1] + bridge_length;
        }
        
        return time;
    }
}