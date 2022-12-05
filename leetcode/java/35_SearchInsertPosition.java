// https://leetcode.com/problems/search-insert-position/?envType=study-plan&id=algorithm-i
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}