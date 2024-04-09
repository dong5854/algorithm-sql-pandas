import java.io.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = HashMap<String, Int>()

    for (i in 0 until n) {
        val key = br.readLine().toCharArray().sorted().joinToString()
        map[key] = (map[key] ?: 0) + 1
    }

    var ans = 0
    for (value in map.values) {
        ans = max(ans, value)
    }

    print(ans)

    br.close()
}