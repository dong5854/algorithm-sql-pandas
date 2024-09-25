import java.util.*;

class 수식복원하기 {

    Set<Integer> candidates;

    public String[] solution(String[] expressions) {

        candidates = new HashSet<>(Arrays.asList(2,3,4,5,6,7,8,9));
        List<String> toSolve = new ArrayList<>();
        for (String expression : expressions) {
            String[] splited = expression.split(" ");
            String num1 = splited[0];
            String operation = splited[1];
            String num2 = splited[2];
            String result = splited[4];
            removeCandidatesByMaxNum(num1, num2, result);
            removeCandidatesByOperation(num1, num2, operation, result);
            if (result.equals("X")) toSolve.add(expression);
        }

        String[] answer = new String[toSolve.size()];
        for (int i=0; i<toSolve.size(); i++) {
            String expression = toSolve.get(i);
            String[] splited = expression.split(" ");
            String num1 = splited[0];
            String operation = splited[1];
            String num2 = splited[2];
            String result = splited[4];
            answer[i] = solve(num1, num2, operation, result);
        }

        return answer;
    }

    public String solve(String num1, String num2, String operation, String result) {
        Set<String> results = new HashSet<>();
        for (Integer candidate : candidates) {
            int num1Decimal = Integer.parseInt(num1, candidate);
            int num2Decimal = Integer.parseInt(num2, candidate);

            if (operation.equals("+")) {
                results.add(Integer.toString(num1Decimal + num2Decimal, candidate));
            } else {
                results.add(Integer.toString(num1Decimal - num2Decimal, candidate));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(num1).append(" ").append(operation).append(" ").append(num2).append(" ").append("=").append(" ");
        if (results.size() > 1) {
            return sb.append("?").toString();
        }
        for (String r: results) {
            for (int candidate : candidates) {
                return sb.append(r).toString();
            }
        }
        return sb.toString();
    }

    public void removeCandidatesByOperation(String num1, String num2, String operation, String result) {
        if (result.equals("X")) return;

        Set<Integer> toRemove = new HashSet<>();
        for (Integer candidate : candidates) {
            int num1Decimal = Integer.parseInt(num1, candidate);
            int num2Decimal = Integer.parseInt(num2, candidate);
            int resultDecimal = Integer.parseInt(result, candidate);
            if (operation.equals("+")) { // 덧셈이 알맞지 않는 경우
                if ((num1Decimal + num2Decimal) != resultDecimal) {
                    toRemove.add(candidate);
                }
            } else { // 뺄셈이 알맞지 않는 경우
                if ((num1Decimal - num2Decimal) != resultDecimal) {
                    toRemove.add(candidate);
                }
            }
        }

        for (Integer r : toRemove) {
            candidates.remove(r);
        }
    }

    public void removeCandidatesByMaxNum(String num1, String num2, String result) {
        int maxNum = 0;
        for (int i = 0; i < num1.length(); i++) {
            int num = num1.charAt(i) - '0';
            maxNum = Math.max(maxNum, num);
        }

        for (int i = 0; i < num2.length(); i++) {
            int num = num2.charAt(i) - '0';
            maxNum = Math.max(maxNum, num);
        }

        if (!result.equals("X")) {
            for (int i = 0; i < result.length(); i++) {
                int num = result.charAt(i) - '0';
                maxNum = Math.max(maxNum, num);
            }
        }

        for (int i = 1; i <= maxNum; i++) {
            candidates.remove(i);
        }

    }
}