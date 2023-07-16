import java.util.*;

class Solution {
    public String removeStars(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }
}