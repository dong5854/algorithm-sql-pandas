import java.util.*;
import java.util.function.Function;

class 숫자변환하기 {
    
    Function<Integer, Integer>[] functions;
    
    
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        
        Set<Integer> visited = new HashSet<>();
        visited.add(x);
        // {value, cnt}
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, 0});
        visited.add(x);

        functions = new Function[3];
        
        functions[0] = (v) -> v + n;
        functions[1] = (v) -> v * 2;
        functions[2] = (v) -> v * 3;
        
        while(!q.isEmpty()) {
            int[] vc = q.poll();
            for (int i = 0; i < 3; i++) {
                int curValue = functions[i].apply(vc[0]);
                int curCnt = vc[1] + 1;
                if (curValue ==  y) return curCnt;
                if (visited.contains(curValue)) continue;
                if (curValue > y) continue;
                q.add(new int[]{curValue, curCnt});
                visited.add(curValue);
            }
        }

        return -1;
    }
}