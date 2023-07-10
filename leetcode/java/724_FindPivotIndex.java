import java.util.stream.*;

class Solution {
    public int pivotIndex(int[] nums) {
        int idx = 0;
        int left = 0;
        int right = IntStream.range(0, nums.length)
            .filter(i -> i != 0)
            .map(i -> nums[i])
            .sum();

        while(idx < nums.length) {
            if (left == right) return idx;
            left += nums[idx];
            if (idx + 1 < nums.length) right -= nums[idx+1];
            else right = 0;
            idx++;
        }

        return -1;
    }
}