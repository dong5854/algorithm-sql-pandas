
// https://leetcode.com/problems/ransom-note/
import java.util.*;;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++) {
            hashmap.put(ransomNote.charAt(i), hashmap.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }
        for(int i = 0; i < magazine.length(); i++) {
            if (hashmap.containsKey(magazine.charAt(i))) {
                hashmap.put(magazine.charAt(i), hashmap.get(magazine.charAt(i)) - 1);
            }
        }
        boolean ans = true;
        for(Integer val : hashmap.values()) {
            if (val > 0) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}