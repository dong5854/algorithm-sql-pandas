// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan&id=algorithm-i
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int sum = 0;
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start+1, end+1};
            }
            if (sum > target) end--;
            else start++;
        }
        return null;
    }
}