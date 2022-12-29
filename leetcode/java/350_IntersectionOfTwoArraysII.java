// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> ansList = new ArrayList<>();

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ansList.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            }
        }

        int[] ans = ansList.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
    
        return ans;
    }
}
// // Hashmap을 사용한 풀이
// public class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//         ArrayList<Integer> result = new ArrayList<Integer>();
//         for(int i = 0; i < nums1.length; i++)
//         {
//             if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
//             else map.put(nums1[i], 1);
//         }
    
//         for(int i = 0; i < nums2.length; i++)
//         {
//             if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
//             {
//                 result.add(nums2[i]);
//                 map.put(nums2[i], map.get(nums2[i])-1);
//             }
//         }
    
//        int[] r = new int[result.size()];
//        for(int i = 0; i < result.size(); i++)
//        {
//            r[i] = result.get(i);
//        }
    
//        return r;
//     }
// }