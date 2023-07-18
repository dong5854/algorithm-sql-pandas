import java.util.*;

class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }


        while(!stack.isEmpty()) {
            sb.insert(0, inBracket(stack));
        }

        return sb.toString();
    }

    private String inBracket(ArrayDeque<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while(true) {
            char c = stack.pop();
            if (c == ']') {
                String bracketVal = inBracket(stack);
                int repeat = getNumber(stack);
                for (int i = 0; i < repeat; i++) {
                    sb.insert(0, bracketVal);
                }
            } else if (c == '[') {
                return sb.toString();
            } else {
                sb.insert(0, c);
            }

            if (stack.isEmpty()) {
                return sb.toString();
            }
        }
    }

    private int getNumber(ArrayDeque<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
            sb.insert(0, stack.pop());
        }

        return Integer.parseInt(sb.toString());
    }
}