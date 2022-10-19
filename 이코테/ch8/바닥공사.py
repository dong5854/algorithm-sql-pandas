d = [0] * 1_001

def solution(n: int) -> int:
    d[1] = 1
    d[2] = 3
    d[3] = 5
    for i in range(4, n+1):
        d[i] = (d[i-1] + d[i-2]  * 2) % 796796

    return d[n]

print(solution(3))