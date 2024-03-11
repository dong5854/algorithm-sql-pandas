import java.util.*;

class HIndex {
    public int solution(int[] citations) {
        Integer[] arr = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            arr[i] = citations[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int ans = 0;
        for (int cnt = 1; cnt <= arr.length; cnt++) {
            if (arr[cnt-1] >= cnt) {
                ans = cnt;
            }
        }
        
        return ans;
    }
}