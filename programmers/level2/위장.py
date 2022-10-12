"""
위장

https://school.programmers.co.kr/learn/courses/30/lessons/42578
"""
def solution(clothes):
    cloth_dict = {}
    for cloth in clothes:
        if cloth[1] in cloth_dict:
            cloth_dict[cloth[1]].append(cloth[0])
        else:
            cloth_dict[cloth[1]] = [cloth[0]]
    
    answer = 1
    for key in cloth_dict:
        answer *= (len(cloth_dict[key]) + 1)
    
    answer -= 1
    return answer