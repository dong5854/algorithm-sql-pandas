"""
1181번
단어 정렬

https://www.acmicpc.net/problem/1181
"""
import sys

amount = int(sys.stdin.readline().strip())
words = []

for _ in range(amount):
  words.append(sys.stdin.readline().strip())

unique_words = list(set(words))
unique_words.sort()
unique_words.sort(key = len)

for i in unique_words:
  print(i)