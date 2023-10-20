import java.util.*;
import java.io.*;

public class CODETREE_숫자빠르게찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).
        mapToInt(Integer::parseInt).
        toArray();

        StringBuilder sb = new StringBuilder();
        for (int  i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            int idx = Arrays.binarySearch(arr, num);
            if (idx >= 0) sb.append(idx+1).append("\n");
            else sb.append(-1).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid + 1;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}