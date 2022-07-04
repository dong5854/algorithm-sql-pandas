"""
1259번
팰린드롬수

https://www.acmicpc.net/problem/1259
"""
while True:
  numbers = input()
  flag = True

  if(numbers == "0"):
    break

  for i in range(len(numbers)//2):
    if(numbers[i] != numbers[len(numbers)-1-i]):
      flag = False

  if flag: print("yes")
  else: print("no")