class JadenCase문자열만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sp = s.split(" ");

        for(int i = 0; i < sp.length; i++){
            if(sp[i].length() == 0) sb.append(" ");
            else{
                sb.append(sp[i].substring(0, 1).toUpperCase());
                sb.append(sp[i].substring(1, sp[i].length()).toLowerCase());
                sb.append(" ");
            }

        }

        if (s.charAt(s.length() - 1) == ' ') return sb.toString();
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}