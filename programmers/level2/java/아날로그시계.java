class 아날로그시계 {

    static class Clock {

        int h,m,s;

        public Clock(int h, int m, int s) {
            this.h = h;
            this.m = m;
            this.s = s;
        }

        public int ringOnce() {
            if ((this.h == 12 || this.h == 0) && this.m == 0 && this.s == 0) {
                return 1;
            }
            return 0;
        }

        public int oneSec() {

            float beforeSecAngle  = ((float) 360 / 60) * this.s;
            float beforeMinAngle  = ((float) 360 / 60) * this.m + ((float) 360 / 60 / 60) * this.s;
            float beforeHourAngle = ((float) 360 / 12) * (this.h % 12) + ((float) 360 / 12 / 60) * this.m + ((float) 360 / 12 / 60 /60) * this.s;

            this.s += 1;
            if (this.s == 60) {
                this.m += 1;
                this.s = 0;
            }
            if (this.m == 60) {
                this.h += 1;
                this.m = 0;
            }


            float afterSecAngle  = ((float) 360 / 60) * this.s;
            float afterMinAngle  = ((float) 360 / 60) * this.m + ((float) 360 / 60 / 60) * this.s;
            float afterHourAngle = ((float) 360 / 12) * (this.h % 12) + ((float) 360 / 12 / 60) * this.m + ((float) 360 / 12 / 60 /60) * this.s;

            if (afterSecAngle == 0) afterSecAngle = 360;
            if (afterMinAngle == 0) afterMinAngle = 360;
            if (afterHourAngle == 0) afterHourAngle = 360;

            int ring = 0;
            if (beforeSecAngle < beforeMinAngle && afterMinAngle <= afterSecAngle) {
                ring += 1;
            }
            if (beforeSecAngle < beforeHourAngle && afterHourAngle <= afterSecAngle) {
                ring += 1;
            }

            if (afterHourAngle == afterMinAngle) ring -= 1;

            return ring;
        }

        @Override
        public boolean equals(Object obj) {
            Clock c = (Clock) obj;
            return this.h == c.h && this.m == c.m && this.s == c.s;
        }
    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        Clock start = new Clock(h1, m1, s1);
        Clock to    = new Clock(h2, m2, s2);

        int answer = 0;

        answer += start.ringOnce();

        while(!start.equals(to)) {
            answer += start.oneSec();
        }

        return answer;
    }
}