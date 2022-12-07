// https://leetcode.com/problems/move-zeroes/submissions/856043297/?envType=study-plan&id=algorithm-i
/*
 * 처음 한 풀이
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for(int num : nums) {
            if (num != 0) {
                nums[idx] = num;
                idx++;
            }
        }

        while (idx < nums.length) {
            nums[idx] = 0;
            idx++;
        }
    }
}