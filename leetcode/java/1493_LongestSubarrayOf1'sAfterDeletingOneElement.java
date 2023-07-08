class Solution {
    public int longestSubarray(int[] nums) {
        boolean flipped = false;
        int start = -1;
        int end = -1;
        int cur = 0;
        int ans = 0;
        while (end < nums.length && start < nums.length) {
            if (end + 1 < nums.length && (nums[end+1] == 1 || !flipped)) {
                if (nums[end+1] == 0 && !flipped) {
                    flipped = true;
                }
                end++;
                cur++;
            } else {
                if (start + 1 < nums.length && nums[start + 1] == 0) {
                    flipped = false;
                }
                start++;
                cur--;
            }
            ans = Math.max(ans, cur);
        }
        return ans - 1;
    }
}