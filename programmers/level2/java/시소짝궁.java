import java.util.*;

class 시소짝궁 {
    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        
        for (int i = 0; i < weights.length; i++) {
            if(!map.containsKey(weights[i])) {
                Set<Integer> temp = new HashSet<>();
                temp.add(i);
                map.put(weights[i], temp);
            } else {
                map.get(weights[i]).add(i);
            }
            set.add(weights[i]);
        }
        
        for (int val : set) {
            
            int duplAmt = map.get(val).size();
            
            int two = val * 2;
            
            if(two % 3 == 0 && map.containsKey(two / 3)) {
                answer += (long) map.get(two / 3).size() * duplAmt;
            }
            
            if(two % 4 == 0 && map.containsKey(two / 4)) {
                answer += (long) map.get(two / 4).size() * duplAmt;
            }
            
            
            int three = val * 3;
            
            if(three % 2 == 0 && map.containsKey(three / 2)) {
                answer += (long) map.get(three / 2).size() * duplAmt;
            }
            
            if(three % 4 == 0 && map.containsKey(three / 4)) {
                answer += (long) map.get(three / 4).size() * duplAmt;
            }
            
            int four = val * 4;
            
            if (four % 2 == 0 && map.containsKey(four / 2)) {
                answer += (long) map.get(four / 2).size() * duplAmt;
            }
            
            if (four % 3 == 0 && map.containsKey(four / 3)) {
                answer += (long) map.get(four / 3).size() * duplAmt;
            }
            
            if (duplAmt > 1) {
                answer += ((long) duplAmt * (duplAmt - 1)) / 2;
            }
            
            map.remove(val);
        }
        
        return answer;
    }
}