import java.io.*;
import java.util.*;


public class CODETREE문제추천시스템1 {

    static class Problem implements Comparable<Problem> {

        int num;
        int diffi;

        public Problem(int num, int diffi) {
            this.num = num;
            this.diffi = diffi;
        }

        @Override
        public int compareTo(Problem o) {
            int c = -Integer.compare(this.diffi, o.diffi);
            if (c == 0) c = -Integer.compare(this.num, o.num);
            return c;
        }
    }

    public static void main(String[] args) throws Exception {
        TreeSet<Problem> set = new TreeSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            set.add(new Problem(p, l));
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if (command.equals("rc")) {
                int val = Integer.parseInt(st.nextToken());
                if (val == -1) {
                    System.out.println(set.last().num);
                } else {
                    System.out.println(set.first().num);
                }
            }
            else if (command.equals("ad")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                set.add(new Problem(p, l));
            }
            else if (command.equals("sv")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                set.remove(new Problem(p, l));
            }
        }

        br.close();
    }
}