// divide-and-conquer(분할 정보 방식 풀이)
// https://leetcode.com/problems/maximum-subarray/description/?envType=study-plan&id=data-structure-i
class Solution {
    public int findMaxSubArray(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = (left + right) / 2;
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;

        // 가운데를 포함해 왼쪽으로 쭉 가는 경우의 최대값
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        // 가운데를 포함하지 않고 오른쪽으로 죽 가는 경우의 최대값
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        // 왼쪽과 오른쪽 서브 어레이의 최소값을 찾는다.
        int maxLeftRight = Math.max(findMaxSubArray(nums, left, mid), findMaxSubArray(nums, mid+1, right));
        
        // 왼쪽과 오른쪽 서브 어레이 중의 최대값, 중간값을 가로지르는 서브어레이의 최대값 중 가장 큰 값을 반환
        return Math.max(maxLeftRight, leftSum + rightSum);
    }

    public int maxSubArray(int[] nums) {
        return findMaxSubArray(nums, 0, nums.length - 1);
    }
}