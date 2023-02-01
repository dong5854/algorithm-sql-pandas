import java.io.*;
import java.util.*;

public class BOJ15684 {

    static int N;
    static int M;
    static int H;

    static boolean[][] ladder;

    static int ans;

    public static void main(String[] args) throws Exception {
        ans = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // H 가로선 1~H 까지 0번은 없는 셈
        // N 세로선 1~N까지 0번 N+1 없는 셈 ex) 1인 경우 1과 2번 연결
        ladder = new boolean[H + 1][N + 2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ladder[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        if (solveLadder()) { // 사다리를 하나도 놓지 않을 때, 이미 정답
            System.out.println(0);
        } else {
            setLadders(1, 0, 1, 1); // 사다리를 1개 놓고,
            if (ans < 4) {
                System.out.println(ans);
                System.exit(0);
            };
            setLadders(2, 0, 1, 1); // 사다리를 2개 놓고,
            if (ans < 4) {
                System.out.println(ans);
                System.exit(0);
            };
            setLadders(3, 0, 1, 1); // 사다리를 3개 놓고,
            if (ans < 4) {
                System.out.println(ans);
                System.exit(0);
            };
            System.out.println(-1);
        }
    }

    public static void setLadders(int targetLadderAmt, int cnt, int cH, int cN) {
        if (cnt == targetLadderAmt) {
            if (solveLadder()) ans = Math.min(ans, cnt);
            return;
        };

        if(cH > H) return;	// 가로선이 마지막에 다다르면

        for(int nH = cH; nH <= H; nH++) {
            for(int nN = 1; nN <= N; nN++) {
                if (ladder[nH][nN+1]) {	// 이미 오른쪽에 사다리가 있으면
                    continue; // 스킵
                } else if (ladder[nH][nN-1]) {	//이미 왼쪽에 사다리가 있으면
                    continue; // 스킵
                } else if (ladder[nH][nN]) { // 이미 사다리가 있으면,
                    continue; // 스킵
                }
                // 사다리 놓고 백트래킹
                ladder[nH][nN] = true;
                setLadders(targetLadderAmt, cnt+1, nH, nN);
                ladder[nH][nN] = false;
            }
        }

    }


    public static boolean solveLadder() {
        for(int i = 1; i <= N; i++) { // 세로 번호 순회, 왼쪽에 있다고 가정
            int cN = i;	// 현재 세로 번호
            int cH = 1;	// 현재 가로 칸
            while(cH <= H) {
                if(ladder[cH][cN-1]) cN--;	// 왼쪽으로
                else if(ladder[cH][cN]) cN++;	// 오른쪽으로
                cH++; // 아래로
            }
            if(i != cN) return false; // 일치하지 않았으면 바로 실패
        }
        return true;
    }
}
