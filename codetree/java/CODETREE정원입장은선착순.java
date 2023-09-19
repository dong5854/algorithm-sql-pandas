import java.util.*;
import java.io.*;

public class CODETREE정원입장은선착순 {

    static class Person {

        int num;
        int arriveAt;
        int stayFor;
        int outAt;

        public Person(int num, int arriveAt, int stayFor) {
            this.num = num;
            this.arriveAt = arriveAt;
            this.stayFor = stayFor;
        }
    }

    static int n;
    static PriorityQueue<Person> wq;
    static PriorityQueue<Person> naq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        wq = new PriorityQueue<>((a, b) -> Integer.compare(a.num, b.num));
        naq = new PriorityQueue<>((a, b) -> Integer.compare(a.arriveAt, b.arriveAt));

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            naq.add(new Person(i,a,t));
        }

        int ans = 0;
        Person inGarden = naq.poll();
        inGarden.outAt = inGarden.arriveAt + inGarden.stayFor;
        int curTime = inGarden.arriveAt;
        while (!wq.isEmpty() || !naq.isEmpty()) {
            // 정원 비움 -> curTime 갱신
            curTime = inGarden.outAt;
            // naq에서 wq까지 현재 시간만큼 옮김
            while (!naq.isEmpty() && naq.peek().arriveAt <= curTime) {
                wq.add(naq.poll());
            }

            // wq에 사람이 안들어가 있으면 naq 제일 앞사람 넣기
            if(wq.isEmpty()) {
                Person temp = naq.poll();
                curTime = temp.arriveAt;
                wq.add(temp);
            }

            // wq에서 num이 가장 우선순위인 사람이 기다린 시간 ans와 비교갱신
            ans = Math.max(ans, curTime - wq.peek().arriveAt);

            // wq에서 num이 가장 우선순위인 사람 정원에 넣기
            inGarden = wq.poll();


            // wq에서 num이 가장 우선순위인 사람이 정원에서 나올 시간 업데이트
            inGarden.outAt = curTime + inGarden.stayFor;
        }

        System.out.println(ans);

        br.close();
    }
}