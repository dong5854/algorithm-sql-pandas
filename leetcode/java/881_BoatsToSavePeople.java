import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int leftPtr = 0; int rightPtr = people.length - 1;
        int cnt = 0;
        while (leftPtr <= rightPtr) {
            cnt++;
            int right = people[rightPtr];
            int left = people[leftPtr];
            // 무거운 사람과 가벼운 사람을 같이 태우지 못하는 경우
            if (right + left > limit) {
                rightPtr--;
            } else{
                leftPtr++;
                rightPtr--;
            }
        }

        return cnt;
    }
}