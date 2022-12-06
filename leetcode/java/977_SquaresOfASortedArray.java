import java.util.*;
// https://leetcode.com/problems/squares-of-a-sorted-array/?envType=study-plan&id=algorithm-i

// /*
//  * 제곱을 한 다음에 오름차순으로 정렬하는 알고리즘으로, 시간 복잡도가 O(nlog(n)) 이다.
//  */
// class Solution {
//     public int[] sortedSquares(int[] nums) {
//         for (int i = 0; i < nums.length; i++) {
//             nums[i] *= nums[i];
//         }
//         Arrays.sort(nums);
//         return nums;
//     }
// }

/*
 * 투 포인터 알고리즘을 사용한 풀이, nums를 한번만 보고 정렬을 따로 하지 않아 시간 복잡도가 O(n)으로 줄어든다.
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;

        int start = 0;
        int end = len - 1;
        int idx = len - 1;

        int[] result = new int[len];

        while (start <= end) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                result[idx] = nums[start] * nums[start];
                start += 1;
            } else {
                result[idx] = nums[end] * nums[end];
                end -= 1;
            }
            idx -= 1;
        }
        return result;
    }
}