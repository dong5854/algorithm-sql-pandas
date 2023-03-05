import java.util.*;
import java.io.*;

public class BOJ1918 {

    static ArrayDeque<Character> stack;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String formula = br.readLine();
        stack = new ArrayDeque<>();
        for (int i = 0;i < formula.length(); i++) {
            char character = formula.charAt(i);
            if ('A' <= character && character <= 'Z') { // 알파벳은 그대로 출력
                sb.append(formula.charAt(i));
                continue;
            }
            if (character == ')') {
                while(!stack.isEmpty()) {
                    if (stack.peek() != '(') {
                        char popped = stack.pop();
                        sb.append(popped);
                    } else {
                        stack.pop();
                        break;
                    }
                }
                continue;
            }
            if (character == '+' || character == '-') {
                while(!stack.isEmpty()) {
                    if (stack.peek() != '(') {
                        char popped = stack.pop();
                        sb.append(popped);
                    } else {
                        break;
                    }
                }
            }
            if (character == '*' || character == '/') {
                while(!stack.isEmpty()) {
                    if (stack.peek() == '*' || stack.peek() == '/') {
                        char popped = stack.pop();
                        sb.append(popped);
                    } else {
                        break;
                    }
                }
            }
            stack.push(character);
        }
        while(!stack.isEmpty()) {
            char popped = stack.pop();
            if (popped == '(') continue;
            sb.append(popped);
        }

        System.out.println(sb);
    }
}