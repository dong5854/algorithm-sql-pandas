import java.util.*;

class 과제진행하기 {

    static class WorkResult {
        boolean done;
        int timeLeft;

        WorkResult(boolean done, int timeLeft) {
            this.done = done;
            this.timeLeft = timeLeft;
        }
    }

    static class Assignment implements Comparable<Assignment>{

        String name;
        int hh;
        int mm;
        int playTime;
        int curTime;

        Assignment(String name, int hh, int mm, int playTime) {
            this.name = name;
            this.hh = hh;
            this.mm = mm;
            this.playTime = playTime;
            this.curTime = 0;
        }

        public WorkResult work(int time) {
            this.curTime += time;
            if (this.curTime >= this.playTime) {
                return new WorkResult(true, this.curTime - this.playTime);
            }
            return new WorkResult(false, 0);
        }

        @Override
        public int compareTo(Assignment o) {
            int c = -Integer.compare(this.hh, o.hh);
            if (c == 0) c = -Integer.compare(this.mm, o.mm);
            return c;
        }
    }


    public List<String> solution(String[][] plans) {

        List<Assignment> list = new ArrayList<>();

        for (String[] plan : plans) {
            String[] time = plan[1].split(":");
            list.add(new Assignment(plan[0], Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(plan[2])));
        }

        list.sort((o1, o2) -> {
            int c = Integer.compare(o1.hh, o2.hh);
            if (c == 0) c = Integer.compare(o1.mm, o2.mm);
            return c;
        });

        List<String> answer = new ArrayList<>();

        PriorityQueue<Assignment> pq = new PriorityQueue();
        pq.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            Assignment curAssignment = pq.peek();
            Assignment newAssignment = list.get(i);
            int timeDiff = getTimeDiff(curAssignment.hh, curAssignment.mm, newAssignment.hh, newAssignment.mm);
            while(!pq.isEmpty()) {
                curAssignment = pq.peek();
                WorkResult wr = curAssignment.work(timeDiff);
                if (wr.done) {
                    answer.add(curAssignment.name);
                    pq.poll();
                    timeDiff = wr.timeLeft;
                } else {
                    break;
                }
            }
            pq.add(newAssignment);
        }

        while(!pq.isEmpty()) {
            answer.add(pq.poll().name);
        }

        return answer;
    }

    public int getTimeDiff(int hh1, int mm1, int hh2, int mm2) {
        int hDiff = hh2 - hh1;
        int mDiff = mm2 - mm1;
        return hDiff * 60 + mDiff;
    }
}