class 이진변환반복하기 {

    int interval = 0;
    int removedZeros = 0;

    public int[] solution(String s) {
        makeOne(s);
        int[] answer = {interval, removedZeros};
        return answer;
    }

    public void makeOne(String s) {
        if (s.equals("1")) return;
        interval++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                removedZeros++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        makeOne(toBinary(sb.length()));
    }

    public String toBinary(int number) {
        StringBuilder sb = new StringBuilder();
        while (number != 1) {
            sb.insert(0, number % 2);
            number /= 2;
        }
        sb.insert(0, number);
        return sb.toString();
    }
}