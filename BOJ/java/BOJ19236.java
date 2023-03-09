import java.util.*;
import java.io.*;
public class BOJ19236 {

    static class Fish implements Comparable<Fish>{

        // 상, 좌상, 좌, 좌하, 하, 우하, 우, 우상 (반시계 방향 8방탐색)
        static final int[] dr = {-1,-1,0,1,1,1,0,-1};
        static final int[] dc = {0,-1,-1,-1,0,1,1,1};

        int dir;
        int size;
        int row, col;

        public Fish(int size, int row, int col, int dir) {
            this.size = size;
            this.row = row;
            this.col = col;
            this.dir = dir;
        }

        private void spin() {
            this.dir = (dir + 1) % 8;
        }

        @Override
        public int compareTo(Fish o) {
            return Integer.compare(this.size, o.size);
        }
    }
    public static void main(String[] args) throws Exception {

    }
}
