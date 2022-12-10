// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/857541882/?envType=study-plan&id=algorithm-i
import java.util.*;
// /*
//  * 슬라이딩 윈도우 기법 O(2n) == O(n)
//  */
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashMap<Character, Integer> chars = new HashMap<>();

//         int left = 0;
//         int right = 0;

//         int ans = 0;
//         while (right < s.length()) {
//             char r = s.charAt(right);
//             chars.put(r, chars.getOrDefault(r, 0) + 1);

//             while (chars.get(r) > 1) {
//                 char l = s.charAt(left);
//                 chars.put(l, chars.get(l) - 1);
//                 left++;
//             }

//             ans = Math.max(ans, right - left + 1);

//             right++;
//         }
//         return ans;
//     }
// }
/*
 * 좀 더 최적화 된 방법 O(n)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> chars = new HashMap<>();
        int ans = 0;
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (chars.containsKey(s.charAt(j))) {
                i = Math.max(chars.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            chars.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}