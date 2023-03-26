import java.io.*;
import java.util.*;

public class BOJ2037 {


    static final char[] firstLetter = {' ', 'A','D','G', 'J', 'M', 'P', 'T', 'W'};
    static int p, w, time;
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        p = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        time = 0;

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int idx = Arrays.binarySearch(firstLetter, c);
            if (idx < 0) idx = ~idx - 1;

            // 공백은 그냥 누루면 된다.
            if (firstLetter[idx] == ' ') {
                time += p;
                continue;
            }

            // 첫번째 글자
            if (i == 0) {
                // 바로 누를 수 있는 경우
                time += p * (c - firstLetter[idx] + 1);
                continue;
            }

            // 2번째 글자부터는 기다려야 할 수 있음
            char prev = input.charAt(i-1);
            int prevIdx = Arrays.binarySearch(firstLetter, prev);
            if (prevIdx < 0) prevIdx = ~prevIdx - 1;
            // 전의 알파벳과 같은 숫자
            if (prevIdx == idx) {
                time += w;
            }
            time += p * (c - firstLetter[idx] + 1);
        }

        System.out.println(time);
    }
}
