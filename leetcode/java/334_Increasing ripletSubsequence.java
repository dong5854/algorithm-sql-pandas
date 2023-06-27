class Solution {
    public boolean increasingTriplet(int[] nums) {
        int low = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int j=0; j < nums.length; j++) {
            if (nums[j] > mid) {
                return true;
            }
            if (nums[j] < low) {
                low = nums[j];
            } else if (nums[j] > low && nums[j] < mid) {
                mid = nums[j];
            }
        }
        
        return false;
    }
}