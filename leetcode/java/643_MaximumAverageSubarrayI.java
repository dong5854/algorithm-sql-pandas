class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = k - 1;
        double sum = 0;
        for (int i = 0 ; i <= end; i++) {
            sum += nums[i];
        }

        double ans = sum;
        for (int e = end + 1; e < nums.length; e++) {
            start++;
            sum -= nums[start - 1];
            sum += nums[e];
            ans = Math.max(ans, sum);
        }

        return ans / k;
    }
}