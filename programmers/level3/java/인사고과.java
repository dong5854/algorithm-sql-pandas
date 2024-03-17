import java.util.*;

public class 인사고과 {
    public int solution(int[][] scores) {
        int[] target = scores[0];
        int targetSum = scores[0][0] + scores[0][1];
        // 근무태도 내림차순, 동료평가 오름차순
        Arrays.sort(scores, (a, b) -> {
            int c = -Integer.compare(a[0], b[0]);
            if (c == 0) c = Integer.compare(a[1], b[1]);
            return c;
        });

        int maxColleague = 0;
        int ans = 1;
        for (int[] score : scores) {
            if (score[1] < maxColleague) {
                if (score.equals(target)) return -1;
            } else {
                maxColleague = Math.max(maxColleague, score[1]);
                if (score[0] + score[1] > targetSum) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        인사고과 solution = new 인사고과();
        System.out.println(solution.solution(new int[][]{{2,2},{1,4},{3,2},{3,2},{2,1}})); // 4
        System.out.println(solution.solution(new int[][]{{3,2},{2,3},{3,2},{2,3}})); // 1
        System.out.println(solution.solution(new int[][]{{2,1},{2,2},{2,3},{3,1}})); // 4
        System.out.println(solution.solution(new int[][]{{7,1},{6,6},{5,4},{5,4},{6, 6}})); // 3
        System.out.println(solution.solution(new int[][]{{2,4},{3,4},{3,5}})); // -1
        System.out.println(solution.solution(new int[][]{{1,5},{3,4},{3,4}})); // 3
    }
}
