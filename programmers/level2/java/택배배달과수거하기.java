class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int deliver = 0; int pickUp = 0;
        long answer = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            deliver += deliveries[i];
            pickUp += pickups[i];
            while (deliver > 0 || pickUp > 0) {
                deliver -= cap;
                pickUp -= cap;
                answer += (i + 1) * 2;
            }
        }
        
        return answer;
    }
}