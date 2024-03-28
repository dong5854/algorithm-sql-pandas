import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = HashMap<String,Int>()
    for (i in 1..n) {
        val key = br.readLine()
        if (map.containsKey(key)) map[key] = map[key]!! + 1 else map[key] = 1
    }

    var ans = 0
    for (key in map.keys) {
        ans = maxOf(ans, map[key]!!)
    }

    println(ans)
    br.close()
}