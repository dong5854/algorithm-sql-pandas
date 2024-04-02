import sys

input = sys.stdin.readline

n, k = map(int, input().rstrip().split())

count= dict()

data = map(int, input().rstrip().split())

for i in data:
    if i in count:
        count[i] += 1
    else:
        count[i] = 1

to_sort = [(count[key], key) for key in count]

sorted_arr = sorted(to_sort)

end_index = len(sorted_arr) - 1
for i in range(end_index, end_index - k, -1):
    print(sorted_arr[i][1], end=" ")