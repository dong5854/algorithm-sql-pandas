import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
    
        Set<Integer> set = new HashSet<>();
        for (int a : map.values()) {
            if (set.contains(a)) return false;
            set.add(a);
        }

        return true;
    }
}