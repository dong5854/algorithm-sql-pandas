var cur : String = "";

class 이진변환반복하기 {
    
    fun removeZeros() : Int {
        var cnt = 0
        val sb = StringBuilder()
        
        val arr = cur.toCharArray()
        for (c : Char in arr) {
            if (c == '0') cnt++
            else sb.append(c)
        }
        cur = sb.toString()
        return cnt
    }
    
    fun binaryChange() : Int {
        var len = cur.length
        val sb = StringBuilder()
        
        while(len > 0) {
            sb.insert(0, len % 2)
            len /= 2
        }
        
        cur = sb.toString()
        
        return 1
    }
    
    fun solution(s: String): IntArray {
        cur = s;
        
        var zeroCnt = 0
        var binaryCnt = 0
        
        while (cur != "1") {
            // 0 제거
            zeroCnt += removeZeros()
            // 이진 변환
            binaryCnt += binaryChange()
        }
        
        return intArrayOf(binaryCnt, zeroCnt)
    }
}
