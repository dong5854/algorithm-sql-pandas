// https://leetcode.com/problems/minimum-size-subarray-sum/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int ans = Integer.MAX_VALUE, cur = 0, cnt = 0;
        while(left < nums.length || right < nums.length) {
            if(cur <= target && right < nums.length) {
                cur += nums[right]; // 제일 오른쪽 추가
                right++; // 후에 하나 올리기
            } else if (cur > target && left < nums.length) {
                cur -= nums[left]; // 제일 왼쪽 빼기
                left++; // 후에 하나 올리기
            } else break;
            int len = right - left;
            if(cur >= target && ans > len) ans = len;
        }
        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
}