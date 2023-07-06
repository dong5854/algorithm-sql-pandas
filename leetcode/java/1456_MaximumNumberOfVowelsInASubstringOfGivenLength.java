import java.util.*;

class Solution {

    final Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public int maxVowels(String s, int k) {
        int ans = 0;
        int start = 0;
        int end = k;

        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) ans++;
        }

        int cur = ans;
        for (int i = end; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) cur++;
            if (set.contains(s.charAt(start++))) cur--;
            ans = Math.max(ans, cur);
        }

        return ans;
    }
}