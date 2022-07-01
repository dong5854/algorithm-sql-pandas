"""
2920번
음계

https://www.acmicpc.net/problem/2920
"""
input = list(map(int, input().split()))

for i in range(len(input)-1):
  if abs(input[i] - input[i+1]) != 1:
    print("mixed")
    exit()
if input[i] - input[i+1] > 0:
  print("descending")
else:
  print("ascending")
