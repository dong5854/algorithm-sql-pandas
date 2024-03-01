from typing import List

def solution(s):
    ans : str = ""
    splitted : List[str] = s.split(" ")
    for string in splitted:
        if len(string) == 0:
            ans += " "
        else :
            ans += string[0].upper()
            ans += string[1:].lower()
            ans += " "    
    
    return ans[0:len(s)]
    