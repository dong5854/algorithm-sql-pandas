import java.util.*;
import java.io.*;

public class BOJ2631 {
    static int N;
    static int[] arr;
    static int[] lis;
    static int j;
    public static void main(String[] args) throws Exception {
        setup();
        getLIS();
        System.out.println(N-(j+1));
    }
    public static void getLIS() {
        lis[0] = arr[0];
        j = 0;
        for (int i = 1; i < N; i++) {
            if(lis[j] < arr[i]) {
                lis[++j] = arr[i];
            } else {
                int idx = ~Arrays.binarySearch(lis,0,j,arr[i]);
                lis[idx] = arr[i];
            }
        }
    }
    public static void setup() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        lis = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}
