import java.util.*;

class Solution {
    public String solution(String input_string) {
        Set<Character> set = new HashSet<>();
        Set<Character> notAlone = new HashSet<>();
        for (int i = 0; i < input_string.length(); i++) {
            char c = input_string.charAt(i);
            if (i == 0) {
                set.add(c);
                continue;
            }
            if (set.contains(c) && input_string.charAt(i-1) != input_string.charAt(i)) {
                notAlone.add(c);
            }
            set.add(c);
        }
        
        if (notAlone.size() == 0) {
            return "N";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 'a'; i <= 'z'; i++) {
            if (notAlone.contains((char) i)) {
                sb.append((char) i);
                notAlone.remove((char) i);
            }
        }
        
        return sb.toString();
    }
}