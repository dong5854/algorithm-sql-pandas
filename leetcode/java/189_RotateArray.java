// https://leetcode.com/problems/rotate-array/description/?envType=study-plan&id=algorithm-i
class Solution {
    public int rotateIndex(int idx, int[] nums, int k) {
        idx += k;
        while (idx > nums.length - 1) {
            idx -= (nums.length);
        }
        return idx;
    }

    public void rotate(int[] nums, int k) {
        int[] copy = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            nums[rotateIndex(i, nums, k)] = copy[i];
        }
    }
}