import sys

N = int(sys.stdin.readline().rstrip())

input_list = []
for _ in range(N):
    input_list.append(int(sys.stdin.readline().rstrip()))

input_list.sort(reverse=True)

for i in input_list:
    print(i, end=" ")