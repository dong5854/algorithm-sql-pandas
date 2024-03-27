import java.io.*
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine(), " ")
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val map = HashMap<Int, Int>()

    st = StringTokenizer(br.readLine(), " ")
    for (i : Int in 1..N) {
        val n = st.nextToken().toInt()
        if (map.containsKey(n)) map[n] = map[n]!! + 1 else map[n] = 1
    }

    st = StringTokenizer(br.readLine(), " ")
    for (i : Int in 1..M) {
        val m = st.nextToken().toInt()
        if (map.containsKey(m)) print("${map[m]} ") else print("0 ")
    }

    br.close()
}