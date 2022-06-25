"""
10872번
팩토리얼

0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/10872
"""
input = int(input())
result = 1

for i in range(input):
  result = result * (i+1)

print(result)