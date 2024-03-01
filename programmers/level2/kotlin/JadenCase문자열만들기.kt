class JadenCase문자열만들기 {
    fun solution(s: String): String {
        val sb = StringBuilder()
        val splitted = s.split(" ")
        for (str in splitted) {
            if (str.length == 0) sb.append(" ")
            else {
                sb.append(str.substring(0,1).toUpperCase())
                sb.append(str.substring(1,str.length).toLowerCase())
                sb.append(" ")
            }
        }
        
        return sb.substring(0, s.length)
    }
}