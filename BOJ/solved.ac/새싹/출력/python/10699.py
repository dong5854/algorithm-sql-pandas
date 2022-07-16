"""
10699번
오늘 날짜

서울의 오늘 날짜를 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/10699
"""
from datetime import datetime

print(datetime.now().strftime("%Y-%m-%d"))