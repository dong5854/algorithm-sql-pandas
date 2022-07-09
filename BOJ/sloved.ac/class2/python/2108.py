"""
2108번
통계학

https://www.acmicpc.net/problem/2108
"""
import sys
import math

n = int(sys.stdin.readline())
nums = []
num_dict = {}

for i in range(n):
  d = int(sys.stdin.readline())
  nums.append(d)
  if d in num_dict:
    num_dict[d] += num_dict[d] + 1
  else:
    num_dict[d] = 1

sorted_nums = sorted(nums)
sorted_items = sorted(num_dict.items(), reverse=True)
sorted_items = sorted(sorted_items, key=lambda item: item[1])

print(round(sum(sorted_nums)/n))
print(sorted_nums[math.floor(n/2)])
if len(sorted_items) == 1:
  print(sorted_items[0][0])
elif sorted_items[-1][1] == sorted_items[-2][1]:
  print(sorted_items[-2][0])
else:
  print(sorted_items[-1][0])
print(sorted_nums[-1] - sorted_nums[0])