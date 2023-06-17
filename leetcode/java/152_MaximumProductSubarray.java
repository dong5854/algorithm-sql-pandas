class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;

        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            temp *= nums[i];
            ans = Math.max(temp, ans);
            if (temp == 0) {
                temp = 1;
            }
        }

        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp *= nums[i];
            ans = Math.max(temp, ans);
            if (temp == 0) {
                temp = 1;
            }
        }
        return ans;
    }
}