import java.util.Scanner;
//https://www.acmicpc.net/problem/14891
public class BOJ14891{
    static int[] one;
    static int[] two;
    static int[] three;
    static int[] four;

    static int[][] system;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        one = new int[10];		// 8개, 오, 왼
        two = new int[10];		// 8개, 오, 왼
        three = new int[10];	// 8개, 오, 왼
        four = new int[10];		// 8개, 오, 왼

        String input = sc.next();
        for(int i = 0; i < 8; i++) {
            one[i] = input.charAt(i) - '0';
        }
        one[8] = 2;
        one[9] = 6;

        input = sc.next();
        for(int i = 0; i < 8; i++) {
            two[i] = input.charAt(i) - '0';
        }
        two[8] = 2;
        two[9] = 6;

        input = sc.next();
        for(int i = 0; i < 8; i++) {
            three[i] = input.charAt(i) - '0';
        }
        three[8] = 2;
        three[9] = 6;

        input = sc.next();
        for(int i = 0; i < 8; i++) {
            four[i] = input.charAt(i) - '0';
        }
        four[8] = 2;
        four[9] = 6;

        system = new int[][]{one, two, three, four};

        int K = sc.nextInt();

        for(int i = 0; i < K; i++) {
            int gearNum = sc.nextInt() - 1;
            int dir = sc.nextInt();
            change(gearNum, dir, 0);
        }

        // 점수 계산
        int score = 0;
        for(int i = 0; i < system.length; i++) {
            int twelveIdx = (system[i][8] + 6) % 8;
            if (system[i][twelveIdx] == 1) {
                score += Math.pow(2, i);
            }
        }
        System.out.println(score);
        sc.close();
    }

    public static void change(int gearNum, int dir, int origin) {
        if (gearNum > 0 && origin != -1) {	// 제일 왼쪽 톱니바퀴가 아니면, 그리고 왼쪽부터 온게 아니면,
            if (system[gearNum-1][system[gearNum-1][8]] != system[gearNum][system[gearNum][9]]) {	// 자신의 왼쪽과 극을 비교 후 회전해야하면,
                change(gearNum-1, -dir, 1);	// 반대 방향으로 회전
            }
        }

        if (gearNum < 3 && origin != 1) {	// 제일 오른쪽 톱니바퀴가 아니면, 그리고 오른쪽부터 온게 아니면,
            if (system[gearNum+1][system[gearNum+1][9]] != system[gearNum][system[gearNum][8]]) {	// 자신의 오른쪽과 극을 비교 후 회전해야만하면,
                change(gearNum + 1, -dir, -1);	// 반대 방향으로 회전
            }
        }

        if(dir == 1) { // 시계방향
            clockWise(system[gearNum]);
        } else { // 반시계방향
            counterClockWise(system[gearNum]);
        }
    }


    public static void counterClockWise(int[] arr) {
        arr[8] = (arr[8] + 1) % 8;
        arr[9] = (arr[9] + 1) % 8;
    }

    public static void clockWise(int[] arr) {
        arr[8] = (arr[8] + 7) % 8;
        arr[9] = (arr[9] + 7) % 8;
    }
}