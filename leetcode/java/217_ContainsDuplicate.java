// https://leetcode.com/problems/contains-duplicate/?envType=study-plan&id=data-structure-i
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> myMap = new HashMap<>();

        for (int num: nums) {
            if (myMap.containsKey(num)) {
                return true;
            }
            myMap.put(num, true);
        }
        return false;
    }
}