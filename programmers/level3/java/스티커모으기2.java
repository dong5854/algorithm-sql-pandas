import java.util.*;

class 스티커모으기2 {
    public int solution(int sticker[]) {
        if (sticker.length == 1) return sticker[0];
        else if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        else if (sticker.length == 3) return Math.max(Math.max(sticker[0], sticker[1]), sticker[2]);

        // 배열 첫번째를 떼었을 때
        int[] firstOff = new int[sticker.length];
        // 배열 첫번째를 떼지 않았을 때
        int[] secondOff = new int[sticker.length];

        // 첫번째 떼인 경우
        firstOff[0] = sticker[0];
        firstOff[1] = sticker[0];
        for (int i = 2; i < sticker.length - 1; i++) {
            firstOff[i] = Math.max(firstOff[i-2] + sticker[i], firstOff[i-1]);
        }

        // 첫번째 떼지 않은 경우
        secondOff[0] = 0;
        secondOff[1] = sticker[1];
        for (int i = 2; i < sticker.length; i++) {
            secondOff[i] = Math.max(secondOff[i-2] + sticker[i], secondOff[i-1]);
        }

        return Math.max(secondOff[sticker.length-1], firstOff[sticker.length-2]);
    }
}