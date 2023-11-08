import java.util.Scanner;
import java.util.Arrays;

public class CODETREE_최대거리의점 {
    public static final int MAX_NUM = 1000000000;
    public static final int MAX_N = 200000;
    
    // 변수 선언
    public static int n, m;
    public static int[] arr = new int[MAX_N];
    
    // 가장 인접한 두 물건의 거리를 dist로 한다 했을 때
    // 물건을 m개 설치할 수 있을지를 판단합니다.
    public static boolean isPossible(int dist) {
        // 설치할 수 있는 물건의 수를 계산합니다.
        // dist가 정해져 있는 이상
        // 최대한 가장 왼쪽부터 설치하는 것이 좋습니다.
        int cnt = 1;
        int lastIdx = 0;
        for(int i = 1; i < n; i++) {
            // 거리가 dist 이상 떨어지게 되는 순간
            // 새로운 물건을 설치하는 것이 최선입니다.
            if(arr[i] - arr[lastIdx] >= dist) {
                // 물건을 하나 더 설치해주고
                // 가장 최근에 놓은 물건의 위치를 
                // 갱신해줍니다.
                cnt++;
                lastIdx = i;
            }
        }
    
        // 설치할 수 있는 물건의 수가 m개 이상이라면 true
        // 아니라면 불가능한 것이므로 false를 반환합니다.
        return cnt >= m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // 물건의 위치를 정렬해줍니다.
        Arrays.sort(arr, 0, n);
        
        int left = 1;                          // 답이 될 수 있는 가장 작은 숫자 값을 설정합니다.
        int right = MAX_NUM;                   // 답이 될 수 있는 가장 큰 숫자 값을 설정합니다.
        int ans = 0;                           // 답을 저장합니다.
        
        while (left <= right) {                // [left, right]가 유효한 구간이면 계속 수행합니다.
            int mid = (left + right) / 2;      // 가운데 위치를 선택합니다.
            if(isPossible(mid)) {              // 결정문제에 대한 답이 Yes라면
                left = mid + 1;                // 오른쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 left를 바꿔줍니다.
                ans = Math.max(ans, mid);           // 답의 후보들 중 최댓값을 계속 갱신해줍니다.
            }
            else                               
                right = mid - 1;               // 결정문제에 대한 답이 No라면 right를 바꿔줍니다.
        }

        System.out.print(ans);
    }
}