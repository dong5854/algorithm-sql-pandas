import sys

N = int(sys.stdin.readline().rstrip())

array = []
for _ in range(N):
    input = sys.stdin.readline().rstrip().split()
    array.append((input[0], int(input[1])))

array.sort(key=lambda student: student[1])

for i in array:
    print(i[0], end=' ')