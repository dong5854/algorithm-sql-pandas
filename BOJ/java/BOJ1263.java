import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1263 {
    static class Work implements Comparable<Work> {
        int load, due;

        public Work(int load, int due) {
            this.load = load;
            this.due = due;
        }

        @Override
        public int compareTo(Work o) {  // 급한 일 먼저 처리
            return Integer.compare(this.due, o.due);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Work[] works = new Work[N];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer  st = new StringTokenizer(br.readLine(), " ");
            works[i] = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if (ans > works[i].due)
                ans = works[i].due;
        }
        Arrays.sort(works);
        while(ans >= 0) {
            int curTime = ans;
            boolean able = true;
            for (int i = 0; i < N; i++) {
                curTime += works[i].load;
                if (curTime > works[i].due){
                    able = false;
                    break;
                }
            }
            if (able) break;
            ans--;
        }

        System.out.println(ans);
    }
}
