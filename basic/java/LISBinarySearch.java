import java.util.Arrays;

public class LISBinarySearch {
    static int[] arr = {3,7,5,2,6,1,4};
    static int N = arr.length;
    static int[] lis = new int[N];  // list 에 있는 값으로 끝나는 idx + 1 길이의 증가 부분 수열이 있다는 뜻
    // ex) [1, 4, 6, 0, 0, 0, 0]
    // 1 로 끝나는 길이 1의 부분 증가 수열이 있다.
    // 4 로 끝나는 길이 2의 부분 증가 수열이 있다. [3,4], [2,4], [1,4]
    // 6 로 끝나는 기리 3의 부분 증가 수열이 있다. [3,5,6]
    static int binarySearch(int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (lis[mid] < target) {
                left = mid + 1;
            } else if (lis[mid] > target) {
                right = mid;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        lis[0] = arr[0];
        int j = 0;
        for (int i = 1; i < N; i++) {
            if (lis[j] < arr[i]) {
                lis[j+1] = arr[i];
                j++;
            } else {
                int idx = binarySearch(0,j,arr[i]);
                lis[idx] = arr[i];
            }
        }
        System.out.println(Arrays.toString(lis));
        System.out.println("LIS 의 최대 길이 " + (j+1));
        for (int i = 0; i <= j; i++) {
            System.out.println(lis[i] + "로 끝나는 길이 " + i + "의 LIS 가 존재");
        }
    }
}
