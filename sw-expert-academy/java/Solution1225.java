//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
import java.util.*;
import java.io.*;

class Solution1225
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {

            int ans = 1;

            StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
            test_case = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(),  " ");

            ArrayDeque<Integer> deque = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            int reducer = 0;
            while (true) {
                reducer++;
                if (reducer > 5) reducer = 1;
                Integer reduced = deque.poll() - reducer;
                if (reduced <= 0) {
                    reduced = 0;
                    deque.add(reduced);
                    break;
                }
                deque.add(reduced);
            }

            sb.append("#").append(test_case);
            for (Integer i: deque) {
                sb.append(" ").append(i);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}