import java.util.Arrays;

public class LIS {

    static int[] arr = {3,7,5,2,6,1,4};
    static int N = arr.length;
    static int[] length = new int[N];
    public static void main(String[] args) {
        for (int k = 0; k < N; k++){
            length[k] = 1;
            for (int i = 0; i < k; i++){
                if(arr[i] < arr[k]){
                    length[k] = Math.max(length[k], length[i] + 1);
                }
            }
        }
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "로 끝나는 길이 " + length[i] + "의 LIS 가 존재");
            j = Math.max(j,length[i]);
        }
        System.out.println("LIS 의 최대 길이 " + j);
        System.out.println(Arrays.toString(length));
    }
}
