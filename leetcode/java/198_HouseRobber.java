// https://leetcode.com/problems/house-robber/description/
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        int[] maxMoney = new int[nums.length];
        maxMoney[0] = nums[0];
        maxMoney[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (maxMoney[i-2] + nums[i] > maxMoney[i-1]) maxMoney[i] = maxMoney[i-2] + nums[i];
            else maxMoney[i] = maxMoney[i-1];
        }
        return maxMoney[nums.length-1];
    }
}
