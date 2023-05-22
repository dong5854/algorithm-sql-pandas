import java.util.*;

class Solution {
    
    List<String> dict = new ArrayList<>();
    final char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {

        for (int i = 1; i <= 5; i++) {
            duplPerm(0, "", i);
        }
        Collections.sort(dict);
        int ans = Collections.binarySearch(dict, word) + 1;
        return ans;
    }
    
    void duplPerm(int cnt, String word, final int limit) {
        if (cnt == limit) {
            dict.add(word);
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            duplPerm(cnt+1,word+vowels[i], limit);
        }
    }
}