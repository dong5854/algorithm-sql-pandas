import java.util.*;

class Solution {
    // 2, 3, 4, 5번 좌석 (111100)
    private static final int LEFT_BLOCK = 0b0000111100;
    // 6, 7, 8, 9번 좌석 (1111000000)
    private static final int RIGHT_BLOCK = 0b1111000000;
    // 4, 5, 6, 7번 좌석 (11110000)
    private static final int MIDDLE_BLOCK = 0b0011110000;

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowToSeats = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            
            if (col >= 2 && col <= 9) {
                rowToSeats.put(row, rowToSeats.getOrDefault(row, 0) | (1 << col));
            }
        }
        
        int maxFamilies = (n - rowToSeats.size()) * 2;
        
        for (int reserved : rowToSeats.values()) {
            boolean left = (reserved & LEFT_BLOCK) == 0;
            boolean right = (reserved & RIGHT_BLOCK) == 0;
            boolean middle = (reserved & MIDDLE_BLOCK) == 0;
            
            if (left && right) {
                maxFamilies += 2;
            } else if (left || right || middle) {
                maxFamilies += 1;
            }
        }
        
        return maxFamilies;
    }
}
