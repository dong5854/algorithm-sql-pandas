/*
11050번
이항 계수 1

https://www.acmicpc.net/problem/11050
*/
package main

import "fmt"

func main() {
  var n, k int
  fmt.Scanln(&n, &k)

  fmt.Println(factorial(n) / (factorial(k) * factorial(n-k)))
}

func factorial(i int) int {
  if i == 0{
    return 1
  }
  return i * factorial(i-1)
}