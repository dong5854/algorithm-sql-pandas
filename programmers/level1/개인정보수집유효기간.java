import java.util.*;

class 개인정보수집유효기간 {
    
    static Map<Character, Integer> map = new HashMap<>();
    
    class Date implements Comparable<Date>{
        int year;
        int month;
        int day;
        
        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        
        @Override
        public int compareTo(Date o) {
            int c = Integer.compare(this.year, o.year);
            if (c == 0) c = Integer.compare(this.month, o.month);
            if (c == 0) c = Integer.compare(this.day, o.day);
            return c;
        }
        
        @Override
        public String toString() {
            return this.year + " " + this.month + " " + this.year;
        }
    }
    
    class Privacy {
        Date date;
        Date expireAt;
        char plan;
        
        public Privacy(int year, int month, int day, char plan) {
            this.date = new Date(year, month, day);
            this.plan = plan;
            month += map.get(plan);
            while (month > 12) {
                year += 1;
                month -= 12;
            }
            this.expireAt = new Date(year, month, day);
        }
        
        public boolean isExpired(Date today) {
            if (0 >= this.expireAt.compareTo(today)) return true;
            return false;
        }
        
    }
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        String[] todaySplit = today.split("\\.");
        Date todayDate = new Date(Integer.parseInt(todaySplit[0]), Integer.parseInt(todaySplit[1]), Integer.parseInt(todaySplit[2]));
        for (String term : terms) {
            StringTokenizer st = new StringTokenizer(term, " ");
            map.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] datePolicy = privacies[i].split(" ");
            String[] privacySplit = datePolicy[0].split("\\.");
            Privacy p = new Privacy(Integer.parseInt(privacySplit[0]), Integer.parseInt(privacySplit[1]), Integer.parseInt(privacySplit[2]), datePolicy[1].charAt(0));
            if (p.isExpired(todayDate)) {
                result.add(i + 1);
            }
        }
        return result;
    }
}

// import java.util.*;

// class 개인정보수집유효기간 {
    
//     Map<String, Integer> termsMap;
    
//     class ContractExpireDate implements Comparable<ContractExpireDate>{
        
//         int year;
//         int month;
//         int date;
//         int idx;
        
//         public ContractExpireDate(String year, String month, String date, int expireAfter, int idx) {
//             this.year = Integer.parseInt(year);
//             this.month = Integer.parseInt(month);
//             this.date = Integer.parseInt(date);
//             this.idx = idx;
//             expireCalc(expireAfter);
//         }
        
//         void expireCalc(int expireAfter) {
//             this.month += expireAfter;
//             this.date -= 1;
//             if (this.date == 0) {
//                 this.month -= 1;
//                 this.date = 28;
//             }
//             if (this.month > 12) {
//                 this.year += this.month / 12;
//                 this.month = this.month % 12;
//                 if (this.month == 0) {
//                     this.year -= 1;
//                     this.month = 12;
//                 }
                
//             }
//         }
        
//         @Override
//         public int compareTo(ContractExpireDate c) {
//             int r = Integer.compare(this.year, c.year);
//             if (r == 0) r = Integer.compare(this.month, c.month);
//             if (r == 0) r = Integer.compare(this.date, c.date);
//             return r;
//         }
        
//     }
    
    
//     public List<Integer> solution(String today, String[] terms, String[] privacies) {
        
//         termsMap = new HashMap<>();
        
//         String[] t = today.split("\\.");
        
//         int year = Integer.parseInt(t[0]);
//         int month = Integer.parseInt(t[1]);
//         int date = Integer.parseInt(t[2]);
        
//         for (String term : terms) {
//             String[] tm = term.split(" ");
//             termsMap.put(tm[0], Integer.parseInt(tm[1]));
//         }
        
//         PriorityQueue<ContractExpireDate> pq = new PriorityQueue<>();
        
//         int idx = 1;
//         for (String p : privacies) {
//             String term = p.split(" ")[1];
//             String[] pt = p.split(" ")[0].split("\\.");
//             ContractExpireDate ced = new ContractExpireDate(pt[0], pt[1], pt[2], termsMap.get(term), idx++);
//             pq.add(ced);
//         }
        
//         List<Integer> answer = new ArrayList<>();
//         while(!pq.isEmpty()) {
//             int c = Integer.compare(pq.peek().year, year);
//             if (c == 0) c = Integer.compare(pq.peek().month, month);
//             if (c == 0) c = Integer.compare(pq.peek().date, date);
            
//             if (c < 0) answer.add(pq.poll().idx);
//             else break;
//         }
        
//         Collections.sort(answer);
//         return answer;
//     }
    
    
// }