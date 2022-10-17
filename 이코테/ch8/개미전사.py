d = [0] * 100

def solution(n: int, m: list) -> int:
    # 조건에 따르면 식량창고의 개수는 3 <= n < 100 이므로 2부터 순회해도 문제없다.
    d[0] = m[0]
    d[1] = max(m[0], m[1])
    # 전의 창고를 터는 것과 현재 창고를 터는 것중 더 많이 터는 것을 선택
    for i in range(2, n):
        d[i] = max(d[i-1], d[i-2] + m[i])

    return d[n-1]

print(solution(4, [1,3,1,5]))