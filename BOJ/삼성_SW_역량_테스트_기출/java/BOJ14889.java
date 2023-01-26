import java.util.Scanner;
//https://www.acmicpc.net/problem/14889
public class BOJ14889 {

    static int ans = Integer.MAX_VALUE;
    static int N;
    static int[][] graph;
    static int[] players;
    static int teamStart;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        graph = new int[N][N];
        players = new int[N];
        teamStart = 0;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        backTracking(0);

        System.out.println(ans);
    }

    public static void backTracking(int pre) {
        if(teamStart >= N / 2) {
            calculate();
            return;
        }

        for(int i = pre;  i < N; i++) {
            if (players[i] == 1) continue;
            players[i] = 1;
            teamStart++;
            backTracking(i+1);
            players[i] = 0;
            teamStart--;
        }
    }

    public static void calculate() {
        int teamStartPower = 0;
        int teamLinkPower = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (players[i] == 1 && players[j] == 1) {
                    teamStartPower += graph[i][j];
                } else if (players[i] == 0 && players[j] == 0) {
                    teamLinkPower += graph[i][j];
                }
            }
        }
        int diff = Math.abs(teamStartPower - teamLinkPower);
        ans = Math.min(ans, diff);
    }
}
