import java.util.*;
import java.io.*;

class BOJ6987 {

    static BufferedReader br;
    static List<int[]> matches;
    static int[] match;

    static void comb(int cnt, int start) {
        if (cnt == 2) {
            matches.add(Arrays.copyOf(match, 2));
            return;
        }

        for (int i = start; i < 6; i++) {
            match[cnt] = i;
            comb(cnt+1, i+1);
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        matches = new ArrayList<>();
        match = new int[2];
        comb(0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int ans = isValid();
            sb.append(ans).append(" ");
        }
        System.out.println(sb);
    }

    static int isValid() throws Exception {

        int[][] results = new int[6][3];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int team = 0; team < 6; team++) {
            int totalGame = 0;
            for (int game = 0; game < 3; game++) {
                results[team][game] = Integer.parseInt(st.nextToken());
                totalGame += results[team][game];
            }
            if (totalGame != 5) return 0;	// 게임은 무조건 다섯판
        }

        if (backtracking(0, results)) return 1;

        return 0;
    }

    static boolean backtracking(int cnt, int[][] results) {
        if (cnt == matches.size()) return true;

        boolean valid;
        int[] m = matches.get(cnt);
        int ourTeam = m[0];
        int enemyTeam = m[1];
        if (results[ourTeam][0] > 0 && results[enemyTeam][2] > 0) {
            // 승 패
            results[ourTeam][0]--;
            results[enemyTeam][2]--;
            valid = backtracking(cnt+1, results);
            results[ourTeam][0]++;
            results[enemyTeam][2]++;
            if (valid) return true;
        }
        if (results[ourTeam][2] > 0 && results[enemyTeam][0] > 0) {
            // 패 승
            results[ourTeam][2]--;
            results[enemyTeam][0]--;
            valid = backtracking(cnt+1, results);
            results[ourTeam][2]++;
            results[enemyTeam][0]++;
            if (valid) return true;
        }
        if (results[ourTeam][1] > 0 && results[enemyTeam][1] > 0) {
            // 무 무
            results[ourTeam][1]--;
            results[enemyTeam][1]--;
            valid = backtracking(cnt+1, results);
            results[ourTeam][1]++;
            results[enemyTeam][1]++;
            if (valid) return true;
        }
        return false;
    }

}