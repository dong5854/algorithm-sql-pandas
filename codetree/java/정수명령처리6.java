import java.io.*;
import java.util.*;

public class 정수명령처리6 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> -Integer.compare(a,b));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] commands = br.readLine().split(" ");
            switch (commands[0]) {
                case "push":
                    pq.add(Integer.parseInt(commands[1]));
                    break;
                case "size":
                    sb.append(pq.size()).append("\n");
                    break;
                case "empty":
                    int val = 0;
                    if (pq.isEmpty()) val = 1;
                    sb.append(val).append("\n");
                    break;
                case "pop":
                    sb.append(pq.poll()).append("\n");
                    break;
                case "top":
                    sb.append(pq.peek()).append("\n");
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);

        br.close();
    }
}