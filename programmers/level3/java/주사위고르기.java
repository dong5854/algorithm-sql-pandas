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


//import java.util.*;
//
//class 주사위고르기 {
//
//    int diceCnt;
//    Map<Integer, Map<Integer, Integer>> singleDice;
//    List<Map<Integer, Integer>> combiDice;
//    List<int[]> combiAns;
//
//    public int[] solution(int[][] dice) {
//
//        diceCnt = dice.length;
//        singleDice = new HashMap<>();
//        combiDice = new ArrayList<>();
//        combiAns = new ArrayList<>();
//
//        // 주사위 눈금
//        for (int i = 0; i < diceCnt; i++) {
//            singleDice.put(i, new HashMap<>());
//            for (int num : dice[i]) {
//                Map<Integer, Integer> map = singleDice.get(i);
//                map.put(num, map.getOrDefault(num, 0) + 1);
//                singleDice.put(i, map);
//            }
//        }
//
//        // 조합별 결과값들
//        comb(diceCnt, 0, 0, new int[diceCnt/2]);
//
//        int winCnt = 0;
//        int[] answer = new int[diceCnt / 2];
//
//        // 제일 승률이 높은 결과
//        for (int i = 0; i < combiAns.size() / 2; i++) {
//            int curWin = 0;
//            int curLose = 0;
//            for (int a : combiDice.get(i).keySet()) {
//                int aVal = combiDice.get(i).get(a);
//                for (int b : combiDice.get(combiDice.size() - 1 - i).keySet()) {
//                    int bVal = combiDice.get(combiDice.size() - 1 - i).get(b);
//                    if (a > b) {
//                        curWin += aVal * bVal;
//                    } else if (b > a) {
//                        curLose += aVal * bVal;
//                    }
//                }
//            }
//
//            if (winCnt < curWin) {
//                winCnt = curWin;
//                answer = combiAns.get(i);
//            }
//            if (winCnt < curLose) {
//                winCnt = curLose;
//                answer = combiAns.get(combiAns.size() - 1 - i);
//            }
//        }
//
//
//        // 마지막 return 해줄때 dice 번호 하나씩 올려주기
//        return Arrays.stream(answer).map(n -> n + 1).toArray();
//    }
//
//    public int[] copyArray(int[] arr) {
//        int[] ret = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            ret[i] = arr[i];
//        }
//        return ret;
//    }
//
//    public void appendComb(int[] result, Map<Integer, Integer> map, int value, int amount, int cnt) {
//        if (cnt == result.length) {
//            map.put(value, map.getOrDefault(value, 0) + amount);
//            return;
//        }
//
//        int diceIdx = result[cnt];
//        for (int key : singleDice.get(diceIdx).keySet()) {
//            int val = singleDice.get(diceIdx).get(key);
//            appendComb(result, map, value + key, amount * val, cnt + 1);
//        }
//
//    }
//
//    public void comb(int num, int cur, int cnt, int[] result) {
//        if (cnt == diceCnt/2) {
//            Map<Integer, Integer> map = new HashMap<>();
//            appendComb(result, map, 0, 1, 0);
//            combiDice.add(map);
//            combiAns.add(copyArray(result));
//            return;
//        }
//
//        for (int i = cur; i < num; i++) {
//            result[cnt] = i;
//            comb(num, i + 1, cnt + 1, result);
//        }
//    }
//}