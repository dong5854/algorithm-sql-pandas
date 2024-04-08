import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val ab = HashMap<Int, Int>()
    val cd = HashMap<Int, Int>()

    val a = br.readLine().trim().split(" ").map { it -> it.toInt() }.toTypedArray()
    val b = br.readLine().trim().split(" ").map { it -> it.toInt() }.toTypedArray()
    val c = br.readLine().trim().split(" ").map { it -> it.toInt() }.toTypedArray()
    val d = br.readLine().trim().split(" ").map { it -> it.toInt() }.toTypedArray()

    for (i in 0 until n) {
        for (j in 0 until n) {
            val abSum = a[i] + b[j]
            val cdSum = c[i] + d[j]
            ab[abSum] = (ab[abSum] ?: 0) + 1
            cd[cdSum] = (cd[cdSum] ?: 0) + 1
        }
    }

    var ans = 0
    for (key in ab.keys) {
        if (cd.containsKey(-key)) {
            ans += ab[key]!! * cd[-key]!!
        }
    }

    println(ans)

    br.close()
}