"""
10809번
알파벳 찾기

알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/10809
"""
s = [ord(i) for i in input()]

for i in range(ord('a'),ord('z')+1):
    if i in s:
        print(s.index(i), end=" ")
    else:
        print(-1, end=" ")
"""
파이썬은 find 함수로 더 쉽게 가능

s = input()

for c in range(ord('a'),ord('z')+1):
    print(s.find(chr(c)))
"""