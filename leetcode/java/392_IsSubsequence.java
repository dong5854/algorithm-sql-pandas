import java.util.*;

class Solution {
    public boolean isSubsequence(String s, String t) {
        ArrayDeque<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            if (!queue.isEmpty() && queue.peek().equals(t.charAt(i))) {
                queue.poll();
            }
        }

        if (queue.isEmpty()) {
            return true;
        }

        return false;
    }
}