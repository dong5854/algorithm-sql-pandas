import java.io.*;
import java.util.*;
class Solution2383
{

    static int N, ans;
    static int[][] graph;
    static ArrayList<Point> people, stairs;

    static class Point {
        int x, y, time;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            people = new ArrayList<>();
            stairs = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if (graph[i][j] == 1) {
                        people.add(new Point(i, j));
                    } else if (graph[i][j] > 1) {
                        stairs.add(new Point(i, j, graph[i][j]));
                    }
                }
            }

            ans = Integer.MAX_VALUE;
            dfs(0, 0);
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    // 백트래킹을 이용한 풀이
    static void dfs(int idx, int select) {
        if (idx == people.size()) {
            // 시뮬레이션 결과중 최솟값으로 업데이트
            int temp = simulate(select);
            if (ans > temp) {
                ans = temp;
            }
            return;
        }
        // 1번 계단을 선택
        dfs(idx + 1, select | (1 << idx));
        // 2번 계단을 선택
        dfs(idx + 1, select);
    }

    static int simulate(int select) {
        PriorityQueue<Integer> stair1 = new PriorityQueue<>();
        PriorityQueue<Integer> stair2 = new PriorityQueue<>();

        for (int i = 0; i < people.size(); i++) {
            Point person = people.get(i);
            // 1을 더하는건 계단에 내려가는데 1초가 걸리기 때문
            int dist1 = Math.abs(person.x - stairs.get(0).x) + Math.abs(person.y - stairs.get(0).y) + 1;
            int dist2 = Math.abs(person.x - stairs.get(1).x) + Math.abs(person.y - stairs.get(1).y) + 1;

            if ((select & (1 << i)) > 0) {
                stair1.add(dist1);
            } else {
                stair2.add(dist2);
            }
        }

        return Math.max(getTime(stair1, stairs.get(0).time), getTime(stair2, stairs.get(1).time));
    }

    // 계단을 처리하는데 걸리는 시간 계산
    static int getTime(Queue<Integer> q, int stairTime) {
        // 계단에서 나갈 시간을 저장할 큐
        Queue<Integer> onStair = new ArrayDeque<>();
        int time = 0;

        // 계단에 내겨갈 사람들과 계단위의 사람들을 전부 처리할 때까지 무한 반복
        while (!q.isEmpty() || !onStair.isEmpty()) {
            time++;
            // 계단에서 내릴 수 있으면 내린다.
            while (!onStair.isEmpty() && onStair.peek() <= time) {
                onStair.poll();
            }

            while (!q.isEmpty() && q.peek() <= time && onStair.size() < 3) {
                onStair.add(time + stairTime);
                q.poll();
            }
        }

        return time;
    }
}