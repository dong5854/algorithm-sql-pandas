import java.util.*;

class 피로도 {
    
    int dungeonAmt;
    int ans;
    boolean[] v;
    
    public int solution(int k, int[][] dungeons) {
        dungeonAmt = dungeons.length;
        v = new boolean[dungeonAmt];
        ans = 0;
        perm(0, dungeons, k, 0);
        return ans;
    }
    
    void perm(int cnt, int[][] dungeons, int energy, int cleared) {
        if (cnt == dungeonAmt) {
            ans = Math.max(ans, cleared);
            return;
        }
        
        for (int i = 0; i < dungeonAmt; i++) {
            if(v[i]) continue;
            v[i] = true;
            if(dungeons[i][0] > energy) {
                perm(cnt+1,dungeons, energy, cleared);
            } else {
                perm(cnt+1,dungeons, energy - dungeons[i][1], cleared+1);
            }
            v[i] = false;
        }
    }
}