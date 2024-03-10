import java.util.*;

class 입국심사 {

    public long solution(int n, int[] times) {
        long ans = Long.MAX_VALUE;
        Arrays.sort(times);
        long left = times[0];
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {
            long mid = (left + right) / 2;
            long people = 0;
            for (int time : times) {
                people += mid / time;
            }
            if (people >= n) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}