import java.util.*;

class Solution {
    public String reverseWords(String s) {

        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] str = s.trim().split("\\s+");

        for (int i = 0; i < str.length; i++) {
            stack.push(str[i]);
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
            if (!stack.isEmpty()) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}