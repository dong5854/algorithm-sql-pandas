import java.util.*;

class Solution {
    
    int answer;
    int studentsAmt;
    boolean[] v;
    
    public int solution(int[][] ability) {
        answer = 0;
        studentsAmt = ability[0].length;
        v = new boolean[ability.length];
        
        solve(ability, 0, 0);
        return answer;
    }
    
    void solve(int[][] ability, int cnt, int sum) {
        if (cnt == studentsAmt) {
            answer = Math.max(answer, sum);
            return;
        }
        
        for (int i = 0; i < ability.length; i++) {
            if (v[i]) continue;
            v[i] = true;
            solve(ability, cnt + 1, sum + ability[i][cnt]);
            v[i] = false;
        }
    }
}