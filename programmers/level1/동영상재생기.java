class 동영상재생기 {

    static class Video {

        int mm;
        int ss;

        int videoLenmm;
        int videoLenss;

        int opStartmm;
        int opStartss;

        int opEndmm;
        int opEndss;

        public Video(String videoLen, String pos, String op_start, String op_end) {
            String[] splited = videoLen.split(":");
            this.videoLenmm = Integer.parseInt(splited[0]);
            this.videoLenss = Integer.parseInt(splited[1]);

            splited = pos.split(":");
            this.mm = Integer.parseInt(splited[0]);
            this.ss = Integer.parseInt(splited[1]);

            splited = op_start.split(":");
            this.opStartmm = Integer.parseInt(splited[0]);
            this.opStartss = Integer.parseInt(splited[1]);

            splited = op_end.split(":");
            this.opEndmm = Integer.parseInt(splited[0]);
            this.opEndss = Integer.parseInt(splited[1]);

            opEnd();
        }

        public void prev() {
            if (this.mm == 0 && this.ss <= 10) {
                this.mm = 0;
                this.ss = 0;
                opEnd();
                return;
            }
            this.ss -= 10;
            if (this.ss < 0) {
                this.mm -= 1;
                this.ss = 60 + this.ss;
            }
            opEnd();
        }

        public void next() {
            this.ss += 10;
            this.mm += this.ss / 60;
            this.ss = this.ss % 60;
            if (this.mm >= this.videoLenmm && this.ss >= this.videoLenss) {
                this.mm = this.videoLenmm;
                this.ss = this.videoLenss;
            }
            opEnd();
        }

        public void opEnd() {
            int curTime = hashTime(this.mm, this.ss);
            int opStart = hashTime(this.opStartmm, this.opStartss);
            int opEnd   = hashTime(this.opEndmm, this.opEndss);
            if (opStart <= curTime && curTime <= opEnd) {
                this.mm = this.opEndmm;
                this.ss = this.opEndss;
            }
        }

        public static int hashTime(int mm, int ss) {
            return mm * 100 + ss;
        }

        @Override
        public String toString() {
            return padLeft(this.mm) + ":" + padLeft(this.ss);
        }

        public String padLeft(int num) {
            if (num < 10) {
                return "0" + num;
            }
            return Integer.toString(num);
        }
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Video video = new Video(video_len, pos, op_start, op_end);
        for (String command : commands) {
            if (command.equals("next")) {
                video.next();
            } else if (command.equals("prev")) {
                video.prev();
            }
        }
        return video.toString();
    }
}