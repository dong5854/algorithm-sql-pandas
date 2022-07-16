"""
2753번
윤년

연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/2753
"""
YEAR = int(input())

if YEAR % 400 == 0:
    print(1)
elif YEAR % 4 == 0 and YEAR % 100 != 0:
    print(1)
else:
    print(0)