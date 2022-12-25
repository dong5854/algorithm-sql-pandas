// https://leetcode.com/problems/search-in-rotated-sorted-array/description/?envType=study-plan&id=algorithm-ii
class Solution {
    public int search(int[] nums, int target) {
        int idx = 0;
        for(int i=0; i<nums.length-1;i++) {
            if(nums[i]>nums[i+1]) {
                idx = i;
                break;
            }
        }
        int left = binarySearch(nums, 0, idx, target);
        int right = binarySearch(nums, idx+1, nums.length-1, target);
        if (left == -1 && right == -1) return -1;
        return left == -1?right:left;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        int ans = -1;
        while (start <= end) {
            int mid = (start + start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                break;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        return ans;
    }
}