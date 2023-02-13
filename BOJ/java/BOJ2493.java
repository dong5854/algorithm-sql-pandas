import java.io.*;
import java.util.*;

public class BOJ2493 {

    static int N;
    static ArrayDeque<int[]> towers;

    public static void main(String[] args)  throws Exception {
        towers = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int tower = Integer.parseInt(st.nextToken());
            // 비교
            while (true) {
                // 더이상 비교할 타워가 없는 경우
                if (towers.isEmpty()) {
                    sb.append(0).append(" ");
                    break;
                }

                // 수신 가능
                if (towers.peek()[0] >= tower) {
                    sb.append(towers.peek()[1]).append(" ");
                    break;
                }
                else towers.pop(); // 수신 불가능 하면 버리기
            }
            towers.push(new int[] {tower, i + 1});
        }

        System.out.println(sb);
        br.close();
    }
}
