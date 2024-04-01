import java.io.*
import java.util.*

fun main() {
   val br = BufferedReader(InputStreamReader(System.`in`))
   val map = HashMap<Int, Int>()
   var st = StringTokenizer(br.readLine(), " ")
   val n = st.nextToken().toInt()
   val k = st.nextToken().toInt()

   var ans = 0
   st = StringTokenizer(br.readLine(), " ")
   for (i in 1..n) {
      val num = st.nextToken().toInt()
      ans += map[k - num] ?: 0
      map[num] = (map[num] ?: 0) + 1
   }

   print(ans)

   br.close()
}