// https://leetcode.com/problems/two-sum/solutions/?envType=study-plan&id=data-structure-i&orderBy=most_relevant
// /*
//  * 내가 처음 푼 답안
//  */
// import java.util.*;
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         HashMap<Integer, List<Integer>> numMap = new HashMap<>();
//         int i = 0;
//         for (int num : nums) {
//             List<Integer> list = new ArrayList<>();
//             if (numMap.containsKey(num)) {
//                 list = numMap.get(num);
//             }
//             list.add(i);
//             numMap.put(num, list);
//             i++;
//         }

//         Arrays.sort(nums);
//         int start = 0;
//         int end = nums.length - 1;
//         while (start < end) {
//             int temp = nums[start] + nums[end];
//             if (temp == target) {
//                 if (numMap.get(nums[start]).size() == 2) {
//                     return numMap.get(nums[start]).stream().mapToInt(Integer::intValue).toArray();
//                 }
//                 return new int[]{numMap.get(nums[start]).get(0), numMap.get(nums[end]).get(0)};
//             }

//             if (temp > target) end--;
//             else start++;
//         }
//         return null;
//     }
// }
/*
 * 모범 답안
 */
import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}