import java.util.*;

class Solution {

    int curTime;

    class Program {
        int score;
        int callTime;
        int runTime;

        public Program(int score, int callTime, int runTime) {
            this.score = score;
            this.callTime = callTime;
            this.runTime = runTime;
        }
    }

    public long[] solution(int[][] program) throws Exception {

        long[] answer = new long[11];

        PriorityQueue<Program> timeQueue = new PriorityQueue<>(new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                int c = Integer.compare(o1.callTime, o2.callTime);
                if (c == 0) {
                    c = Integer.compare(o1.score, o2.score);
                }
                return c;
            }
        });

        PriorityQueue<Program> waitQueue = new PriorityQueue<>(new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                int c = Integer.compare(o1.score, o2.score);
                if (c == 0) {
                    c = Integer.compare(o1.callTime, o2.callTime);
                }
                return c;
            }
        });

        // 1. timeQueue에 전부 삽입
        for (int[] p : program) {
            timeQueue.add(new Program(p[0], p[1], p[2]));
        }

        // 2. 첫 호출
        Program firstProgram = timeQueue.poll();
        curTime = firstProgram.callTime;
        waitQueue.add(firstProgram);

        // 3. timeQueue의 프로그램이 전부 사라질 때까지
        while (!timeQueue.isEmpty()) {
            if (waitQueue.isEmpty()) {  // 대기 큐에 없을 경우
                Program nextProgram = timeQueue.poll();
                curTime = nextProgram.callTime;
                waitQueue.add(nextProgram);
            }

            Program curProgram = waitQueue.poll();  // 현재 실행중인 프로그램
            answer[curProgram.score] += (curTime - curProgram.callTime); // 대기시간 추가
            curTime += curProgram.runTime;  // 프로그램 끝
            while (timeQueue.peek() != null && curTime >= timeQueue.peek().callTime) {  // 현재 시점에서 호출된 프로그램들 waitQueue에 삽입
                waitQueue.add(timeQueue.poll());
            }
        }

        // 4. waitQueue에 남아있는 나머지 처리
        while(!waitQueue.isEmpty()) {
            Program curProgram = waitQueue.poll();  // 현재 실행중인 프로그램
            answer[curProgram.score] += (curTime - curProgram.callTime); // 대기시간 추가
            curTime += curProgram.runTime;  // 프로그램 끝
        }

        answer[0] = curTime;

        return answer;
    }
}