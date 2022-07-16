"""
10845번
큐

https://www.acmicpc.net/problem/10845
"""
import sys

N = int(sys.stdin.readline())
queue = []

for i in range(N):
  command = sys.stdin.readline().rstrip().split()
  
  #push
  if len(command) == 2:
    if command[0] == 'push':
      queue.append(int(command[1]))  

  #pop
  if command[0] == 'pop':
    if len(queue) == 0:
      print(-1)
    else:
      print(queue.pop(0))

  #size
  if command[0] == 'size':
    print(len(queue))

  #empty
  if command[0] == 'empty':
    if len(queue) == 0:
      print(1)
    else:
      print(0)

  #front
  if command[0] == 'front':
    if len(queue) == 0:
      print(-1)
    else:
      print(queue[0])

  #back
  if command[0] == 'back':
    if len(queue) == 0:
      print(-1)
    else:
      print(queue[-1])