import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1],0) + 1);
        }
        
        int comb = 1;
        for (String v : map.keySet()) {
            comb *= (map.get(v) + 1);
        }
        return --comb;
    }
}