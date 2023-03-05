import java.util.Arrays;

public class LIS {

    static int[] arr = {3,7,5,2,6,1,4};
    static int n = arr.length;
    static int[] length = new int[n];
    public static void main(String[] args) {
        for (int k = 0; k < n; k++){
            length[k] = 1;
            for (int i = 0; i < k; i++){
                if(arr[i] < arr[k]){
                    length[k] = Math.max(length[k], length[i] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(length));
    }
}
