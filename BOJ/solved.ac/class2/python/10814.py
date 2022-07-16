"""
10814번
나이순 정렬

https://www.acmicpc.net/problem/10814
"""
N = int(input())
data = []
for i in range(N):
  a,b = input().split()
  data.append({"age": int(a), "name": b})

temp = sorted(data, key=(lambda x: x["age"]))

for i in temp:
  print(i["age"], i["name"])
"""
생각해보니 굳이 딕셔너리를 사용할 필요가 없음
import sys

N = int(sys.stdin.readline())
data = []

for i in range(N):
  data.append(sys.stdin.readline().split())

temp = sorted(data, key=(lambda x: int(x[0])))

for i in temp:
  print(i[0], i[1])
"""