import java.io.*;
import java.util.*;

public class BOJ10799 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int N = input.length(); int ans = 0;
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else {
                stack.pop();
                if (input.charAt(i-1) == '(') { // 레이저
                    ans += stack.size();
                } else {    // 쇠막대기 끝
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
