import java.util.*;

class 공원 {
    public int solution(int[] mats, String[][] park) {
        int R = park.length;
        int C = park[0].length;
        
        // 돗자리 크기들을 내림차순으로 정렬
        Arrays.sort(mats);
        
        // 돗자리를 큰 순서부터 시도
        for (int i = mats.length - 1; i >= 0; i--) {
            int target = mats[i];
            
            // 공원의 각 위치에서 돗자리를 놓을 수 있는지 확인
            for (int r = 0; r <= R - target; r++) {
                for (int c = 0; c <= C - target; c++) {
                    if (canPlaceMat(park, r, c, target)) {
                        return target;  // 놓을 수 있으면 해당 크기 반환
                    }
                }
            }
        }
        
        return -1;  // 아무 돗자리도 놓을 수 없는 경우
    }

    // 주어진 (r, c)에서 target 크기의 돗자리가 놓일 수 있는지 확인하는 함수
    private boolean canPlaceMat(String[][] park, int r, int c, int target) {
        for (int i = 0; i < target; i++) {
            for (int j = 0; j < target; j++) {
                if (!park[r + i][c + j].equals("-1")) {
                    return false;  // 빈 공간이 아닌 곳이 있으면 false
                }
            }
        }
        return true;  // 모두 빈 공간이면 true
    }
}
