// https://leetcode.com/problems/first-unique-character-in-a-string/?envType=study-plan&id=data-structure-i
import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        for(int i=0; i < s.length();  i++) if(map.get(s.charAt(i)) == 1) return i;
        return -1;
    }
}
