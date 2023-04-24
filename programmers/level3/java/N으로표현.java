import java.util.*;

class N으로표현 {

    Set<Integer>[] dp;

    public int solution(int N, int number) {
        dp = new Set[9];

        dp[0] = new HashSet<>();
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
            // 연산 없이 단순히 이어 붙이기
            dp[i].add(getN(N, i));
        }

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= i; j++) {
                // 8 초과는 알 필요 없음
                if (i + j > 8) continue;
                for (Integer val1 : dp[i]) {
                    for (Integer val2 : dp[j]) {
                        // 합
                        dp[i+j].add(val1 + val2);
                        // 곱
                        dp[i+j].add(val1 * val2);
                        // 차
                        dp[i+j].add(val1 - val2);
                        dp[i+j].add(val2 - val1);
                        // 나눗셈
                        if (val2 != 0 && val1 % val2 == 0) {
                            dp[i+j].add( val1 / val2);
                        }
                        if (val1 != 0 && val2 % val1 == 0) {
                            dp[i+j].add(val2 / val1);
                        }
                    }
                }
            }
        }

        for (int i = 1; i <=8; i++) {
            if(dp[i].contains(number)) {
                return i;
            }
        }
        return -1;
    }

    public int getN(int val, int idx) {
        int ret = val;
        for (int i = 1; i < idx; i++) {
            ret = ret * 10 + val;
        }
        return ret;
    }
}