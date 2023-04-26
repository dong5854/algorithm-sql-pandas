import java.util.*;

class Solution {
    
    static int ans = Integer.MAX_VALUE;
    static boolean[] v;
    static String[] w;
    
    public int solution(String begin, String target, String[] words) {        
        v = new boolean[words.length];
        w = words;
        
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (isNotOneDiff(begin, words[i])) continue;
            candidates.add(i);
        }
        System.out.println(candidates);
        for (Integer c : candidates) {
            dfs(target, c, 1);
        }
        if (ans == Integer.MAX_VALUE) {
            ans = 0;
        }
        return ans;
    }
    
    public void dfs(String target, int position, int cnt) {
        if (w[position].equals(target)) {
            if (ans > cnt) {
                ans = cnt;
            }
            return;
        }
        
        v[position] = true;
        String word = w[position];
        for (int i = 0; i < w.length; i++) {
            if (v[i]) continue;
            if (isNotOneDiff(word, w[i])) continue;
            dfs(target, i, cnt + 1);
        }
        v[position] = false;
    }
    
    boolean isNotOneDiff(String one, String two) {
        int diff = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != two.charAt(i)) {
                diff++;
            }
        }
        if (diff != 1) {
            return true;
        }
        return false;
    }
}