// https://leetcode.com/problems/valid-parentheses/
import java.util.*;;
class Solution {
    public boolean isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}
