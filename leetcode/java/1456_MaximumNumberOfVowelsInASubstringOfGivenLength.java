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

/**
 * leetcode에 공개되어있는 가장 간단한 코드
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
 */
// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int start=0;
//         int end=0;
//         int zeros=0;
//         while(end<nums.length){
//             if(nums[end++] == 0){
//                 zeros++;
//             }
//             if(zeros>k){
//                 if(nums[start++] == 0){
//                     zeros--;
//                 }
//             }
//         }
//         return end-start;
//     }
// }