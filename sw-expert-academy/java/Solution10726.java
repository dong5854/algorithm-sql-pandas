import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution10726
{
    static StringTokenizer st;
    static int N, M;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int lastNBit = (1<<(N)) - 1;
            if (lastNBit == (M & lastNBit)) {
                sb.append("#").append(test_case).append(" ").append("ON").append("\n");
            } else {
                sb.append("#").append(test_case).append(" ").append("OFF").append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}