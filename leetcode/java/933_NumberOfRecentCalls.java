import java.util.*;

class RecentCounter {

    int prev;
    ArrayDeque<Integer> queue;

    public RecentCounter() {
        prev = -3000;
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.add(t);
        prev = t - 3000;
        while(queue.peek() < prev) {
            queue.poll();
        }

        return queue.size();
    }
}

/**
* Your RecentCounter object will be instantiated and called as such:
* RecentCounter obj = new RecentCounter();
* int param_1 = obj.ping(t);
*/