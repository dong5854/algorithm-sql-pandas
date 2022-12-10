// https://leetcode.com/problems/permutation-in-string/description/
import java.util.*;
/*
 * 나중에 sliding window 사용해서 다시 풀어보기
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1Map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> s2Map = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                s2Map.put(s2.charAt(i+j), s2Map.getOrDefault(s2.charAt(i+j), 0) + 1);
            }
            if (matches(s1Map, s2Map)) return true;
        }
        return false;
    }
    public boolean matches(HashMap<Character, Integer> s1Map, HashMap<Character, Integer> s2Map) {
        for (char key : s1Map.keySet()) {
            if (!s1Map.get(key).equals(s2Map.getOrDefault(key, -1))) return false;
        }
        return true;
    }
}