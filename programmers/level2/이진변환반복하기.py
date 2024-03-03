from collections import deque
from typing import List, Deque

cur: str = ""


def remove_zeros() -> int:
    global cur
    cnt: int = 0
    temp: List[str] = []

    for c in cur:
        if c == '0':
            cnt += 1
        else:
            temp.append(c)

    cur = ''.join(temp)
    return cnt


def binary_change() -> int:
    global cur
    length: int = len(cur)
    temp: Deque[str] = deque()

    while length > 0:
        temp.appendleft(str(length % 2))
        length = length // 2

    cur = ''.join(temp)
    return 1


def solution(s):
    global cur
    cur = s

    zero_cnt: int = 0
    binary_cnt: int = 0

    while cur != "1":
        zero_cnt += remove_zeros()
        binary_cnt += binary_change()

    return [binary_cnt, zero_cnt]