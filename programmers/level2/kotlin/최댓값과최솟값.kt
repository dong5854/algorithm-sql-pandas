class 최댓값과최솟값 {
    fun solution(s: String): String {
        val nums = s.split(" ").map{it.toInt()}
        return "${nums.minOrNull()} ${nums.maxOrNull()}"
    }
}