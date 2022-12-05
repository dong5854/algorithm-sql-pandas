// dp 사용(카데인 알고리즘), 정석은 divide-and-conquer 방식인 듯 하니 해당 풀이로도 풀어보자.
// https://leetcode.com/problems/maximum-subarray/description/?envType=study-plan&id=data-structure-i
class Solution {
    public int maxSubArray(int[] nums) {
        int tempMax = nums[0];
        int allMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            tempMax = Math.max(tempMax + nums[i], nums[i]);
            allMax = Math.max(allMax, tempMax);
        }

        return allMax;
    }
}