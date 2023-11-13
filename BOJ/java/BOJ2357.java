import java.io.*;
import java.util.*;

class BOJ2357 {

    static int N, M;
    static long[][] leaf;
    static long[][] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int height = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = 1 << (height + 1);

        // {min, max}
        leaf = new long[N][2];
        tree = new long[treeSize][2];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            leaf[i] = new long[]{num, num};
        }

        build(1, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int  i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long[] ans = query(1, 0, N-1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = leaf[start];
            return;
        }

        int mid = (start + end) / 2;
        // left
        build(node * 2, start, mid);
        // right
        build(node * 2 + 1, mid + 1, end);

        tree[node][0] = Math.min(tree[node * 2][0], tree[node * 2 + 1][0]);
        tree[node][1] = Math.max(tree[node * 2][1], tree[node * 2 + 1][1]);
    }

    static long[] query(int node, int start, int end, int targetStart, int targetEnd) {
        // 아예 포함되지 않는 경우
        if (start > targetEnd || end < targetStart) {
            return new long[] {Long.MAX_VALUE, Long.MIN_VALUE};
        }

        // 전부 포함되는 경우
        if (targetStart <= start && end <= targetEnd) {
            return tree[node];
        }

        // 일부 포함되는 경우
        int mid = (start + end) / 2;
        long[] left = query(node * 2, start, mid, targetStart, targetEnd);
        long[] right = query(node * 2 + 1, mid + 1, end, targetStart, targetEnd);

        return new long[] {Math.min(left[0], right[0]), Math.max(left[1], right[1])};
    }
}