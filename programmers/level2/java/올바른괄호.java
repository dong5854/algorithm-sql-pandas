import java.util.*;

class 올바른괄호 {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else {
                stack.push('(');
            }
        }
        
        if (!stack.isEmpty()) return false;
        
        return true;
    }
}