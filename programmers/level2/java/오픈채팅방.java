import java.util.*;

class 오픈채팅방 {
    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> userInfo = new HashMap<>();
        
        for (String r: record) {
            if (r.contains("Enter") || r.contains("Change")) {
                String[] info = r.split(" ");
                userInfo.put(info[1], info[2]);
            }
        }
        
        for (String r: record) {
            String[] info = r.split(" ");
            if (r.contains("Enter")) {
                answer.add(userInfo.get(info[1]) + "님이 들어왔습니다.");
            } else if (r.contains("Leave")) {
                answer.add(userInfo.get(info[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer;
    }
}