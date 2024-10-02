import java.util.*;

class 두큐합같게만들기 {
    
    ArrayDeque<int[]> q1;
    ArrayDeque<int[]> q2;
    
    long total;
    long q1Val;
    
    public int solution(int[] queue1, int[] queue2) {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
        
        total = 0;
        q1Val = 0;
        
        for (int i : queue1) {
            q1Val += i;
            total += i;
            q1.add(new int[]{i, 0});
        }
        
        for (int i : queue2) {
            total += i;
            q2.add(new int[]{i, 0});
        }
        
        int ans = 0;

        while(!q1.isEmpty() && q1.peekFirst()[1] == 0) {
            if (q1Val == total - q1Val) { // q1 == q2
                return ans;
            }
            else if (q1Val > total - q1Val) { // q1 에서 빼야할 경우
                ans++;
                int[] temp = q1.poll();
                q1Val -= temp[0];
                q2.add(new int[]{temp[0], temp[1] + 1}); // 처음 보낼 때 1
            } else { // q2 에서 가져와야 하는 경우
                ans++;
                int[] temp = q2.poll();
                q1Val += temp[0];
                q1.add(new int[]{temp[0], temp[1]});
            }
        }

        return -1;
    }
}