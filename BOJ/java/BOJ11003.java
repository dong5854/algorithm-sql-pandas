import java.io.*;
import java.util.*;

class BOJ11003 {

    static int N;
    static int L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        // {idx, val}
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;

        while (idx < N) {
            if (!dq.isEmpty() && dq.peekFirst()[0] <= idx - L) dq.pollFirst();
            int val = Integer.parseInt(st.nextToken());
            if(dq.isEmpty()) dq.add(new int[] {idx, val});
            else if (dq.peekLast()[1] > val){
                while (!dq.isEmpty() && dq.peekLast()[1] >= val) dq.removeLast();
                dq.add(new int[]{idx, val});
            } else {
                dq.add(new int[]{idx, val});
            }
            sb.append(dq.peekFirst()[1]).append(" ");
            idx++;
        }

        System.out.println(sb);

        br.close();
    }
}