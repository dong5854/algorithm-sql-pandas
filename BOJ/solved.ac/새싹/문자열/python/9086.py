"""
9086번
문자열

문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/9086
"""
import sys

amount = int(input())

for i in range(amount):
    s = sys.stdin.readline().rstrip()
    print(f"{s[0]}{s[-1]}")
"""
변수 인라인해서 코드 길이 단축 가능
import sys

for i in range(int(input())):
    s = sys.stdin.readline().rstrip()
    print(f"{s[0]}{s[-1]}")
"""