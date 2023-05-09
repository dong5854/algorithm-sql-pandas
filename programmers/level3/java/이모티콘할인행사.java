import java.util.*;

class Solution {
    
    static final int[] discountRate = new int[]{10, 20, 30, 40};
    
    static PriorityQueue<int[]> pq;
    
    public int[] solution(int[][] users, int[] emoticons) {
        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int c = -Integer.compare(o1[0], o2[0]);
                if (c == 0) c = -Integer.compare(o1[1], o2[1]);
                return c;
                }
            });
        
        int[] rate = new int[emoticons.length];
        getCase(users, emoticons, rate, 0);
        int[] ans = pq.poll();
        return ans;
    }
    
    public void getCase(int[][] users, int[] emoticons, int[] rate, int cnt) {
        if (cnt == emoticons.length) {
            int totalPlus = 0;
            int totalPrice = 0;
            nextUser: for (int[] user : users) {
                int price = 0;
                for (int i = 0; i < cnt; i++) {
                    if (user[0] <= rate[i]) {
                        price += (emoticons[i] * ((100 - rate[i]) / (double)100));
                    }
                    if (price >= user[1]) {
                        totalPlus += 1;
                        continue nextUser;
                    }
                }
                totalPrice += price;
            }
            pq.add(new int[]{totalPlus, totalPrice});
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            rate[cnt] = discountRate[i];
            getCase(users, emoticons, rate, cnt+1);
        }
    }
    
}