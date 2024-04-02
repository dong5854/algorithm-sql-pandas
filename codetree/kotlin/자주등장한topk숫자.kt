import java.io.*
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine(), " ")
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val map = HashMap<Int, Int>()
    st = StringTokenizer(br.readLine(), " ")
    for (i in 1..n) {
        val idx = st.nextToken().toInt()
        map[idx] = (map[idx] ?: 0) + 1
    }

    val list = ArrayList<Array<Int>>()
    for (key in map.keys) {
        list.add(arrayOf(key, map[key]!!))
    }

    list.sortWith(compareBy<Array<Int>> { it[1] }.thenBy { it[0] })

    for (i in list.size - 1 downTo list.size - k) {
        print("${list[i][0]} ")
    }

    br.close()
}
