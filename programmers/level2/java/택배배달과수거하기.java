class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int deliver = 0; int pickUp = 0;
        long answer = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            deliver += deliveries[i];
            pickUp += pickups[i];
            while (deliver > 0 || pickUp > 0) {
                deliver -= cap;
                pickUp -= cap;
                answer += (i + 1) * 2;
            }
        }
        
        return answer;
    }
}

// import java.util.*;

// class 택배배달과수거하기 {
//     public long solution(int cap, int n, int[] deliveries, int[] pickups) {
                    
            
//         // {거리, 필요한 수}
//         ArrayDeque<int[]> dStack = new ArrayDeque<>();
//         ArrayDeque<int[]> pStack = new ArrayDeque<>();
        
//         for (int i = 0; i < n; i++) {
//             if (deliveries[i] > 0) dStack.push(new int[]{i + 1, deliveries[i]});
//             if (pickups[i] > 0) pStack.push(new int[]{i + 1, pickups[i]});
//         }
        
//         long answer = 0;
//         while (!dStack.isEmpty() || !pStack.isEmpty()) {
            
//             int pickupCap = cap;
//             int deliverCap = cap;
            
//             if (!dStack.isEmpty() && !pStack.isEmpty()) {
//                 answer += Math.max(dStack.peek()[0], pStack.peek()[0]) * 2;
//             } else if(!dStack.isEmpty()) {
//                 pickupCap = 0;
//                 answer += dStack.peek()[0] * 2;
//             } else if(!pStack.isEmpty()) {
//                 deliverCap = 0;
//                 answer += pStack.peek()[0] * 2;
//             }
            
//             while (pickupCap != 0 && !pStack.isEmpty()) {
//                 int[] temp = pStack.pop();
//                 if (temp[1] <= pickupCap) {
//                     pickupCap -= temp[1];
//                 } else {
//                     temp[1] -= pickupCap;
//                     pickupCap = 0;
//                     pStack.push(temp);
//                 }
//             }
            
//             while (deliverCap != 0 && !dStack.isEmpty()) {
//                 int[] temp = dStack.pop();
//                 if (temp[1] <= deliverCap) {
//                     deliverCap -= temp[1];
//                 } else {
//                     temp[1] -= deliverCap;
//                     deliverCap = 0;
//                     dStack.push(temp);
//                 }
//             }
            
//         }
//         return answer;
//     }
// }