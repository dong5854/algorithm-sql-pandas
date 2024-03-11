import java.util.*;

class 타겟넘버 {
    
    int ans = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return ans;
    }
    
    public void dfs(int[] numbers, int target, int cnt, int cur) {
        if (cnt == numbers.length) {
            if (target == cur) ans++;
            return;
        }
        
        dfs(numbers, target, cnt + 1, cur + numbers[cnt]);
        dfs(numbers, target, cnt + 1, cur - numbers[cnt]);
    }
}