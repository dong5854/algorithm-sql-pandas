import java.util.*;
import java.io.*;

class Solution1288
{
    static int N;
    static int cnt;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            Set<Integer> set = new HashSet<>();
            N = Integer.parseInt(br.readLine());
            cnt = 0;
            int val = 0;
            while (set.size() != 10) {
                val += N;
                int temp = val;
                while (temp > 0) {
                    set.add(temp % 10);
                    temp = temp / 10;
                }
            }
            sb.append("#").append(test_case).append(" ").append(val).append("\n");
        }
        System.out.println(sb);
    }
}