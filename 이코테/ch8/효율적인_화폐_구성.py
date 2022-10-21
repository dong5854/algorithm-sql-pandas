def solution(n: int, m: int, input: list) -> int:
    d = [10_001] * (m + 1)

    d[0] = 0
    for i in range(n):
        for j in range(input[i], m+1):
            if d[j - input[i]] != 10_001:
                d[j] = min(d[j], d[j - input[i]] + 1)

    if d[m] == 10_001:
        return -1

    return d[m]
    
    



print(solution(2, 15, [2,3]))

print(solution(3, 4, [3,5,7]))