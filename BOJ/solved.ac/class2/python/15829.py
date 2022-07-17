"""
15829번
Hashing

https://www.acmicpc.net/problem/15829
"""
import sys
  
N = int(sys.stdin.readline().rstrip())

sum = 0
power = 0
for char in sys.stdin.readline().rstrip():
  sum += (ord(char)-96) * 31**power
  power += 1

print(sum % 1234567891)