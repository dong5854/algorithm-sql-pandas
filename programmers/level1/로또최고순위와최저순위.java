import java.util.*;

class Solution {
    
    Set<Integer> winSet = new HashSet<>();
    
    public int[] solution(int[] lottos, int[] win_nums) {
        for (int w : win_nums) {
            winSet.add(w);
        }
        
        int zeros = 0;
        int hits = 0;
        
        for (int l : lottos) {
            if (l == 0) {
                zeros += 1;
                continue;
            }
            if (winSet.contains(l)) {
                hits += 1;
            }
        }
        
        int min = 7 - hits;
        int max = 7 - hits - zeros;
        if (max >= 6) {
            max = 6;
        }
        if (min >= 6) {
            min = 6;
        }
        
        return new int[]{max, min};
    }
}