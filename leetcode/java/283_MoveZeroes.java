// https://leetcode.com/problems/move-zeroes/submissions/856043297/?envType=study-plan&id=algorithm-i
// /*
//  * 처음 한 풀이 시간 복잡도는 O(n) 이지만 0일 경우에 쓰기작업을 따로 해줘야해서 개선 여지 있음
//  */
// class Solution {
//     public void moveZeroes(int[] nums) {
//         int idx = 0;
//         for(int num : nums) {
//             if (num != 0) {
//                 nums[idx] = num;
//                 idx++;
//             }
//         }

//         while (idx < nums.length) {
//             nums[idx] = 0;
//             idx++;
//         }
//     }
// }
/*
 * 개선된 방법 시간복잡도는 O(n) 이지만 0 일 경우는 건너 뛸 수 있어 더 빠르다.
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int slowidx =0;
        for(int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] != 0) {
                int temp = nums[slowidx];
                nums[slowidx++] = nums[idx];
                nums[idx] = temp;
            }
        }
    }
}