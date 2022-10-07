"""
불량 사용자

https://school.programmers.co.kr/learn/courses/30/lessons/64064
"""
"""
TypeError: unhashable type: 'list' 에러가 발생해서 유효하지 못한 풀이
visited = [False for _ in range(8)]
ban_visited = [False for _ in range(8)]
ans_list = []
answer = 0
cnt = 0

def banned_check(user_id: str, banned_id: str):
    if len(user_id) != len(banned_id):
        return False
    for i in range(len(user_id)):
        if banned_id[i] == "*":
            continue
        elif banned_id[i] != user_id[i]:
            return False
        
    return True
    
def dfs(user_id: list, banned_id: list):
    global visited, ban_visited, answer, cnt, ans_list
    for i in range(len(user_id)):
        for j in range(len(banned_id)):
            if banned_check(user_id[i],banned_id[j]) and visited[i] == False and ban_visited[j] == False:
                ban_visited[j] = True
                visited[i] = True
                cnt += 1
                if j == len(banned_id) -1 and cnt == len(banned_id):
                    answer += 1
                    ans_list.append(visited[:])
                    print(ans_list)
                dfs(user_id, banned_id)
                cnt -= 1
                ban_visited[j] = False
                visited[i] = False
        

def solution(user_id, banned_id):
    global answer, ans_list
    
    dfs(user_id, banned_id)
    
    return len(set(ans_list))
"""