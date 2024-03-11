import java.util.*;

class 구명보트 {
    public int solution(int[] people, final int limit) {
        int answer = 0;
        Arrays.sort(people);
        int sPtr = 0; int bPtr = people.length - 1;
        int curSum = people[bPtr];
        while (sPtr <= bPtr) {
            if (sPtr == bPtr) {
                answer++;
                break;
            }
            if (curSum + people[sPtr] <= limit) {   // 가벼운 사람을 태울 수 있으면,
                sPtr++;
            }
            answer++;
            curSum = people[--bPtr];
        }
        return answer;
    }
}