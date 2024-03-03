class 이진변환반복하기 {
    
    static String cur;
    
    public int removeZeros() {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        
        char[] arr = cur.toCharArray();
        for (char c : arr) {
            if (c == '0') cnt++;
            else sb.append(c);
        }
        cur = sb.toString();
        return cnt;
    }
    
    public int binaryChange() {
        int len = cur.length();
        StringBuilder sb = new StringBuilder();
        
        while(len > 0) {
            sb.insert(0, len % 2);
            len /= 2;
        }
        cur = sb.toString();
        
        return 1;
    }
    
    public int[] solution(String s) {
        cur = s;
        
        int zeroCnt = 0;
        int binaryCnt = 0;
        
        while (!cur.equals("1")) {
            // 0 제거
            zeroCnt += removeZeros();
            // 이진 변환
            binaryCnt += binaryChange();
        }
        
        return new int[]{binaryCnt, zeroCnt};
    }
}

// class 이진변환반복하기 {

//     int interval = 0;
//     int removedZeros = 0;

//     public int[] solution(String s) {
//         makeOne(s);
//         int[] answer = {interval, removedZeros};
//         return answer;
//     }

//     public void makeOne(String s) {
//         if (s.equals("1")) return;
//         interval++;
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '0') {
//                 removedZeros++;
//             } else {
//                 sb.append(s.charAt(i));
//             }
//         }
//         makeOne(toBinary(sb.length()));
//     }

//     public String toBinary(int number) {
//         StringBuilder sb = new StringBuilder();
//         while (number != 1) {
//             sb.insert(0, number % 2);
//             number /= 2;
//         }
//         sb.insert(0, number);
//         return sb.toString();
//     }
// }