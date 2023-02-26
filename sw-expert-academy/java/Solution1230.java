import java.io.*;
import java.util.*;

class Solution1230
{
    static StringTokenizer st;
    static List<Integer> list;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        int N;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            list = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");

            // 원본 암호문
            for(int i=0; i<N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            // 명령어 개수
            int Q = Integer.parseInt(br.readLine());

            // 명령어
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < Q; i++) {
                char cmd = st.nextToken().charAt(0);
                func(cmd);
            }

            // 출력
            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void func(char cmd) {
        int x, y;;
        switch (cmd) {
            case 'I':
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                for (int i = 0, insertIdx = x; i < y; i++, insertIdx++) {
                    list.add(insertIdx, Integer.parseInt(st.nextToken()));
                }
                break;
            case 'D':
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                for (int i = 0; i < y; i++) {
                    list.remove(x);
                }
                break;
            case 'A':
                y = Integer.parseInt(st.nextToken());
                for (int i = 0; i < y; i++) {
                    list.add(Integer.parseInt(st.nextToken()));
                }
                break;
            default:
                break;
        }
    }
}