// https://leetcode.com/problems/find-all-anagrams-in-a-string/
import java.util.*;;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[26];

        for(int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
        }
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']--;
            if(i-start >= p.length()) map[s.charAt(start++) - 'a']++;
            if(isAllZero(map)) ans.add(start);
        }
        return ans;
    }

    private boolean isAllZero(int[] map){
        for (int i = 0; i <map.length ; i++) {
            if(map[i] != 0) return false;
        }
        return true;
    }
}