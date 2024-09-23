import java.util.*;

class 퍼즐게임챌린지 {
    
    static class Puzzle {
        
        int diff;
        int time;
        int prevTime;
        
        Puzzle(int diff, int time, int prevTime) {
            this.diff = diff;
            this.time = time;
            this.prevTime = prevTime;
        }
        
        long solveTime(int level) {
            if (diff <= level) {
                return (long) this.time;
            }
            return (long) (diff - level) * (time + prevTime) + time;
        }
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int minLevel = Integer.MAX_VALUE;
        int maxLevel = 0;
        List<Puzzle> puzzles = new ArrayList<>();
        
        for (int i = 0; i < diffs.length; i++) {
            minLevel = Math.min(minLevel, diffs[i]);
            maxLevel = Math.max(maxLevel, diffs[i]);
            if (i == 0) {
                puzzles.add(new Puzzle(diffs[i], times[i], 0));
            } else {
                puzzles.add(new Puzzle(diffs[i], times[i], times[i-1]));
            }
        }
        
        return binarySearch(minLevel, maxLevel, limit, puzzles);
    }
    
    public long solve(int level, List<Puzzle> puzzles) {
        long time = 0;
        for (Puzzle p : puzzles) {
            time += p.solveTime(level);
        }
        return time;
    }
    
    public int binarySearch(int minLevel, int maxLevel, long limit, List<Puzzle> puzzles) {
        int answer = maxLevel;
        while (minLevel <= maxLevel) {
            int midLevel = (minLevel + maxLevel) / 2;

            if (solve(midLevel, puzzles) <= limit) {
                answer = midLevel;
                maxLevel = midLevel - 1;
            } else {
                minLevel = midLevel + 1;
            }
        }

        return answer;
    }
}