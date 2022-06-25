"""
10951번
A+B - 4

두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/10951
"""
import sys

for i in sys.stdin:
        a,b = map(int,i.split())
        print(a+b)