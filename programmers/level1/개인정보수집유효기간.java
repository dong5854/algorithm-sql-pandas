import java.util.*;

class Solution {
    
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