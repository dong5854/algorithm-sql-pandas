import java.util.*;

class 양궁대회 {
    
    int scoreDiff;
    int[] ans;
    int[] info;
    
    public int[] solution(int n, int[] info) {
        this.scoreDiff = -1;
        this.info = new int[11];
        for (int i = 0; i < 11; i++) {
            this.info[10-i] = info[i];
        }
        lionScore(10, n, new int[11]);
        if (scoreDiff <= 0) return new int[]{-1};
        
        int[] ansReverse = new int[11];
        for (int i = 0; i < 11; i++) {
            ansReverse[10-i] = ans[i];
        }
        return ansReverse;
    }
    
    public void lionScore(int idx, int cnt, int[] lionInfo) {
        if (idx == 0) {
            lionInfo[idx] += cnt;
            int diff = getScoreDiff(lionInfo);
            if (diff >= 0 && diff > this.scoreDiff) { // 점수 차이가 더 큰 경우
                this.scoreDiff = diff;
                ans = copyArr(lionInfo);
            } else if (diff >= 0 && diff == this.scoreDiff && mustChange(lionInfo)) { // 점수 차이는 같지만 교체해야 할 경우
                this.scoreDiff = diff;
                ans = copyArr(lionInfo);
            }
            lionInfo[idx] -= cnt;
            return;
        }
        if (this.info[idx] > 0 && cnt > this.info[idx]) { // 아파치가 화살을 맞췄는데 이보다 많이 맞추는 경우
            lionInfo[idx] += (this.info[idx] + 1);
            lionScore(idx - 1, cnt - (this.info[idx] + 1), lionInfo);
            lionInfo[idx] -= (this.info[idx] + 1);
        }
        if (this.info[idx] > 0 && cnt >= this.info[idx]) { // 아파치가 화살을 맞췄는데 같은 점수를 낸 경우
            lionInfo[idx] += this.info[idx];
            lionScore(idx - 1, cnt - this.info[idx], lionInfo);
            lionInfo[idx] -= this.info[idx];
        }
        if (this.info[idx] == 0 && cnt > 0) { // 아파치가 화살을 못맞춰서 하나만 맞춰 득점하는 경우
            lionInfo[idx]++;
            lionScore(idx - 1, cnt - 1, lionInfo);
            lionInfo[idx]--;
        }
        lionScore(idx - 1, cnt, lionInfo); // 득점을 포기하는 경우
    }
    
    public int getScoreDiff(int[] arr) {
        int aScore = 0;
        int lScore = 0;
        for (int i = 0; i < 11; i++) {
            if (arr[i] > this.info[i]) {
                lScore += i;
            } else if (this.info[i] > 0 && this.info[i] >= arr[i]) {
                aScore += i;
            }
        }
        return lScore - aScore;
    }
    
    public boolean mustChange(int[] arr) {
        for (int i = 0; i < 11; i++) {
            if (this.ans[i] < arr[i]) return true;
            else if (this.ans[i] > arr[i]) return false;
        }
        return true;
    }
    
    public int[] copyArr(int[] arr) {
        int[] ret = new int[11];
        for (int i = 0; i < 11; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
}
