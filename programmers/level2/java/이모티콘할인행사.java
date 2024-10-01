import java.util.*;

class 이모티콘할인행사 {

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

//import java.util.*;
//
//class Solution {
//
//    static class User {
//
//        int ratio;
//        int price;
//        int bought;
//
//        User(int ratio, int price) {
//            this.ratio = ratio;
//            this.price = price;
//            this.bought = 0;
//        }
//
//        public void emoticon(int price, int discount) {
//            if (this.ratio <= discount) {
//                this.bought += (price / 100) * (100-discount);
//            }
//        }
//
//        public void reset() {
//            this.bought = 0;
//        }
//
//        public boolean usePlus() {
//            return this.bought >= this.price;
//        }
//
//        @Override
//        public String toString() {
//            return this.ratio + " " + this.price + " " + this.bought;
//        }
//    }
//
//    final int[] discountRatio = {10, 20, 30, 40};
//    List<int[]> permutations;
//    List<User> userList;
//
//    public int[] solution(int[][] users, int[] emoticons) {
//        permutations = new ArrayList<>();
//        userList = new ArrayList<>();
//
//        // 유저 리스트 초기화
//        for (int[] u : users) {
//            userList.add(new User(u[0], u[1]));
//        }
//
//        // 가능한 할인 조합
//        permutation(0, emoticons.length, new int[emoticons.length]);
//
//        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
//            int c = -Integer.compare(o1[0], o2[0]);
//            if (c == 0) c = -Integer.compare(o1[1], o2[1]);
//            return c;
//        });
//
//        for (int[] p : permutations) {
//            for (User u : userList) {
//                for (int i = 0; i < p.length; i++) {
//                    u.emoticon(emoticons[i], p[i]);
//                }
//            }
//
//            int[] r = new int[2];
//            for (User u : userList) {
//                if (u.usePlus()) r[0]++;
//                else r[1] += u.bought;
//                u.reset();
//            }
//
//            q.add(r);
//        }
//        return q.poll();
//    }
//
//
//    public void permutation(int cnt, int num, int[] result) {
//        if (cnt == num) {
//            permutations.add(copyArray(result));
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            result[cnt] = discountRatio[i];
//            permutation(cnt+1, num, result);
//        }
//    }
//
//    public int[] copyArray(int[] org) {
//        int[] ret = new int[org.length];
//        for (int i = 0; i < org.length; i++) {
//            ret[i] = org[i];
//        }
//        return ret;
//    }
//
//}