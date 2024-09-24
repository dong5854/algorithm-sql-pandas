import java.util.*;

class 충돌위험찾기 {
    
    // key : hashFunction(초, r좌표, c좌표), value : 존재하는 로봇의 수
    Map<Integer, Integer> map;
    
    public int hashFunction(int sec, int r, int c) {
        return sec * 1_000_000 + r * 1000 + c;
    }
    
    public int solution(int[][] points, int[][] routes) {
        map = new HashMap<>();
        int answer = 0;
        
        // 최대 100 번 연산
        for (int[] route : routes) {
            int sec = 0;
            int row = points[route[0]-1][0];
            int col = points[route[0]-1][1];
            
            int mapKey = hashFunction(sec, row, col);
            map.put(mapKey, map.getOrDefault(mapKey, 0) + 1);
            // 첫충돌이면 충돌 위험 추가
            if (map.get(mapKey).equals(2)) answer++;
            
            // 최대 100 번 연산
            for (int i = 1; i < route.length; i++) {
                int dRow = points[route[i]-1][0];
                int dCol = points[route[i]-1][1];
                
                while (row != dRow) { 
                    if (row < dRow) row++;
                    else row--;
                    sec++;
                    
                    mapKey = hashFunction(sec, row, col);
                    map.put(mapKey, map.getOrDefault(mapKey, 0) + 1);
                    // 첫충돌이면 충돌 위험 추가
                    if (map.get(mapKey).equals(2)) answer++;
                }
                
                while (col != dCol) {
                    if (col < dCol) col++;
                    else col--;
                    sec++;
                    
                    mapKey = hashFunction(sec, row, col);
                    map.put(mapKey, map.getOrDefault(mapKey, 0) + 1);
                    // 첫충돌이면 충돌 위험 추가
                    if (map.get(mapKey).equals(2)) answer++;
                }
            }
        }
        
        return answer;
    }
}