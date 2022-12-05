// https://leetcode.com/problems/binary-search/?envType=study-plan&id=algorithm-i

class Solution {
    public int search(int[] nums, int target, int left, int right) {
        if (left >= right) return -1;
        
        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            return mid;
            
        } 
        if (target > nums[mid]) {
            return search(nums, target, mid + 1, right);
        } else {
            return search(nums, target, left, mid);
        }
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        return search(nums, target, 0, len);
    }
}