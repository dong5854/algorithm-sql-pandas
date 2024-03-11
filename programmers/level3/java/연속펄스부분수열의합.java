import java.util.*;

class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        long[] aSeq = new long[sequence.length + 1];
        long[] bSeq = new long[sequence.length + 1];
        
        int pulse = 1;
        for (int i = 0; i < sequence.length; i++) {
            aSeq[i+1] = pulse * sequence[i];
            bSeq[i+1] = -pulse * sequence[i];
            pulse *= -1;
        }
        
        long ans = Long.MIN_VALUE;
        for (int i = 1; i <= sequence.length; i++) {
            aSeq[i] = Math.max(aSeq[i], aSeq[i] + aSeq[i-1]);
            bSeq[i] = Math.max(bSeq[i], bSeq[i] + bSeq[i-1]);
            ans = Math.max(ans, Math.max(aSeq[i], bSeq[i]));
        }
        
        return ans;
    }
}