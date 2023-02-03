// https://leetcode.com/problems/interval-list-intersections/
import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstPointer = 0, secondPointer = 0;
        List<int[]> ans = new ArrayList<>();
        while(firstPointer < firstList.length && secondPointer < secondList.length) {
            int[] temp = new int[2];

            // 페어 첫번째
            if(firstList[firstPointer][0] > secondList[secondPointer][0]) temp[0] = firstList[firstPointer][0]; 
            else temp[0] = secondList[secondPointer][0];

            // 페어 두번째
            if(firstList[firstPointer][1] < secondList[secondPointer][1]) temp[1] = firstList[firstPointer][1];
            else temp[1] = secondList[secondPointer][1];

            if(temp[0] <= temp[1]) ans.add(temp);

            // 포인터 이동
            if(firstList[firstPointer][1] == temp[1]) firstPointer++;
            if(secondList[secondPointer][1] == temp[1]) secondPointer++; 
        }
        return ans.toArray(new int[ans.size()][]);
    }
}