import java.util.*;

class 카펫 {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        double sqrt =  Math.floor(Math.sqrt(sum));
        int[] ans = new int[2];
        for (int i = (int)sqrt; i <= sum; i++) {
            if (sum % i == 0) {
                int width = Math.max(i, sum / i);
                int height = Math.min(i, sum / i);
                if ((width-2) * (height-2) == yellow) {
                    ans[0] = width;
                    ans[1] = height;
                    break;
                }
            }
        }
        return ans;
    }
}