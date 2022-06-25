"""
2420번
사파리월드

두 서브도메인의 유명도가 주어졌을 때, 그 차이를 구하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/2420
"""
inputs = list(map(int, input().split()))

print(abs(inputs[0] - inputs[1]))