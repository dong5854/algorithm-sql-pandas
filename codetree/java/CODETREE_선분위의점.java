import java.io.*;
import java.util.*;

public class CODETREE_선분위의점 {

    static int n;
    static int m;
    static int[] list;

    static int upperBound(int sIdx, int eIdx, int target) {
        int rIdx = -1;
        while (sIdx <= eIdx) {
            int mIdx = (sIdx + eIdx) / 2;
            if (list[mIdx] < target) {
                sIdx = mIdx + 1;
            } else {
                eIdx = mIdx - 1;
                rIdx = mIdx;
            }
        }

        return rIdx;
    }

        static int lowerBound(int sIdx, int eIdx, int target) {
        int rIdx = -1;
        while (sIdx <= eIdx) {
            int mIdx = (sIdx + eIdx) / 2;
            if (list[mIdx] <= target) {                
                sIdx = mIdx + 1;
                rIdx = mIdx;
            } else {
                eIdx = mIdx - 1;
            }
        }

        return rIdx;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int sIdx = 0;
            int eIdx = n-1;
            int f = upperBound(sIdx, eIdx, s);
            int l = lowerBound(sIdx, eIdx, e);
            if (f == -1 || l == -1) sb.append(0);
            else sb.append(l - f + 1);
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}