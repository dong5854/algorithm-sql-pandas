import java.util.*;

class 큰수만들기 {
    public String solution(String number, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && stack.peek() < number.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString().substring(0, sb.length() - k);
    }
}