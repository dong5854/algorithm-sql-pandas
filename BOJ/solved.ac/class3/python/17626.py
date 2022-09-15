"""
17626번
Four Squares

https://www.acmicpc.net/problem/17626
"""
import sys

n = int(sys.stdin.readline().rstrip())

dp_list = [5 for _ in range(50001)]

dp_list[0] = 0
dp_list[1] = 1 # 1^2
dp_list[2] = 2 # 1^2 + 1^2
dp_list[3] = 3 # 1^2 + 1^2 + 1^2
dp_list[4] = 1 # 2^2
dp_list[5] = 2 # 1^2 + 2^2
dp_list[6] = 3 # 1^2 + 1^2 + 2^2
dp_list[7] = 4 # 1^2 + 1^2 + 1^2 + 2^2
dp_list[8] = 2 # 2^2 + 2^2
dp_list[9] = 1 # 3^3

for i in range(2, n+1):
    min_value = 4
    j = 1
    while j**2 <= i:
        min_value = min(min_value, dp_list[i-(j*j)] + 1)
        j += 1
    dp_list[i] = min_value

print(dp_list[n])
