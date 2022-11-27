"""
2579번
계단 오르기

https://www.acmicpc.net/problem/2579
"""
import sys

n = int(sys.stdin.readline().rstrip())

steps = [int(sys.stdin.readline().rstrip()) for _ in range(n)]

dp_list = [0 for _  in range(n)]


if n == 1:
    dp_list[0] = steps[0]
elif n == 2:
    dp_list[1] = steps[0] + steps[1]
else:
    # 첫칸의 최대값
    dp_list[0] = steps[0]
    # 둘째칸의 최대값은 첫칸 + 둘째칸의 합
    dp_list[1] = steps[0] + steps[1]
    # 셋째칸의 최대값은 첫째칸 + 셋째칸, 둘째칸 + 셋째칸
    dp_list[2] = max(steps[0] + steps[2], steps[1] + steps[2])

    for i in range(3, n):
        # 둘째전 + 현재칸과 셋째전 + 두 계단 연속 중 큰값
        dp_list[i] = max(dp_list[i-2] + steps[i], dp_list[i-3] + steps[i] + steps[i-1])

print(dp_list[n-1])