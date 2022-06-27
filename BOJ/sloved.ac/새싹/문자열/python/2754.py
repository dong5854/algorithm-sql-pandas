"""
2754번
학점계산

어떤 사람의 C언어 성적이 주어졌을 때, 평점은 몇 점인지 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/2754
"""
grade = input()
score = 0

if(grade[0] == "A"):
    score += 4.0
elif(grade[0] == "B"):
    score += 3.0
elif(grade[0] == "C"):
    score += 2.0
elif(grade[0] == "D"):
    score += 1.0
else:
    print(0.0)
    exit()

if(grade[1] == "+"):
    score += 0.3
elif(grade[1] == "-"):
    score -= 0.3

print(score)