import java.io.*
import java.util.*
import kotlin.collections.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine(), " ")

    val list = ArrayList<Int>()
    val map = HashMap<Int, Int>()

    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    st = StringTokenizer(br.readLine(), " ")
    for (i in 1..n) {
        val num = st.nextToken().toInt()
        map[num] = (map[num] ?: 0) + 1
        list.add(num)
    }

    var ans = 0
    for (i in 0 until n) {
        val num1 =  list[i]
        map[num1] = map[num1]!! - 1
        for (j in 0 until i) {
            val num2 =  list[j]
            ans += map[k - num1 - num2] ?: 0
        }
    }

    print(ans)

    br.close()
}