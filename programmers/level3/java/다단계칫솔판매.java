import java.util.*;

class 다단계칫솔판매 {
    
    static Map<String, String> referralMap;
    static Map<String, Integer> amountMap;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        referralMap = new HashMap<>();
        amountMap = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            referralMap.put(enroll[i], referral[i]);
            amountMap.put(enroll[i], 0);
        }
        
        for (int i = 0; i < seller.length; i++) {
            sell(seller[i], amount[i] * 100);
        }
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = amountMap.get(enroll[i]);
        }
        
        return answer;
    }
    
    static void sell(String seller, Integer cost) {
        int toGive = cost / 10;
        int mine = cost - toGive;
        
        amountMap.put(seller, amountMap.get(seller) + mine);
        
        if (toGive == 0) {
            return;
        }
        
        if (referralMap.get(seller).equals("-")) {
            return;
        }
        
        sell(referralMap.get(seller), toGive);
    }
}