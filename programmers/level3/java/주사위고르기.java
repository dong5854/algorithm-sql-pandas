import java.util.*;

public class 주사위고르기 {
    int[][] dice;
    List<int[]> diceComb;
    Map<Integer, List<Integer>> combIdxSum;
    int[] temp;

    public int[] solution(int[][] dice) {
        this.dice = dice;
        this.diceComb = new ArrayList<>();
        this.temp = new int[dice.length / 2];
        // 주사위 조합 구하기
        diceComb(0, 0, dice.length);
        // 조합 별 이기는 경우
        combIdxSum = new HashMap<>();
        for (int i = 0; i < diceComb.size(); i++) {
            combIdxSum.put(i, new ArrayList<>());
            scoreComb(i, 0, 0);
            combIdxSum.get(i).sort(Integer::compareTo);
        }
        // 각 조합에 대해 이기는 경우 계산하기
        int maxSum = 0;
        int[] ans = new int[dice.length/2];
        for (int aIdx = 0; aIdx < combIdxSum.size(); aIdx++) {
            int sum = 0;
            List<Integer> aComb = combIdxSum.get(aIdx);
           for (int i = 0; i < aComb.size(); i++) {
                sum += binarySearch(aComb.get(i), combIdxSum.get(combIdxSum.size() - 1 - aIdx));
           }
           if (maxSum < sum) {
               maxSum = sum;
               ans = diceComb.get(aIdx);
           }
        }
        return Arrays.stream(ans).map(n -> n + 1).toArray();
    }

    public int binarySearch(int target, List<Integer> bComb) {
        int low = 0;
        int high = bComb.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (bComb.get(mid) < target) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }

    public void scoreComb(int combIdx, int diceIdx, int sum) {
        if (diceIdx == diceComb.get(combIdx).length) {
            combIdxSum.get(combIdx).add(sum);
            return;
        }
        int targetDice = diceComb.get(combIdx)[diceIdx];
        for (int i = 0; i < 6; i++) {
            scoreComb(combIdx, diceIdx + 1, sum + dice[targetDice][i]);
        }
    }


    public void diceComb(int cnt, int start, int diceAmt) {
        if (cnt == dice.length / 2) {
            int[] toAdd = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                toAdd[i] = temp[i];
            }
            diceComb.add(toAdd);
            return;
        }

        for (int i = start; i < diceAmt; i++) {
            temp[cnt] = i;
            diceComb(cnt + 1, i + 1, diceAmt);
        }
    }

    public static void main(String[] args) {
        주사위고르기 solution = new 주사위고르기();
        System.out.println(Arrays.toString(
                solution.solution(new int[][]{
                {1, 2, 3, 4, 5, 6},
                {4, 4, 3, 3, 3, 3},
                {1, 3, 3, 4, 4, 4},
                {1, 1, 4, 4, 5, 5}
        })));

    }
}
