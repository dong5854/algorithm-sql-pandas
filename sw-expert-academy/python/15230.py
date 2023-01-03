n = int(input())

for i in range(n):
    cnt = 0
    alpa = ord('a')
    line = input()
    for i in line:
        if i == chr(alpa):
            cnt += 1
        else:
            break
        alpa += 1
    print(cnt)