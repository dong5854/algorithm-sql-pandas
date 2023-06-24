import java.util.*;

class Solution {

    final char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    public String reverseVowels(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (vowelContains(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (vowelContains(s.charAt(i))) {
                sb.append(stack.pop());
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public boolean vowelContains(char targetValue) {
        for(char s: vowels){
            if(s == targetValue)
                return true;
        }
        return false;
    }
}