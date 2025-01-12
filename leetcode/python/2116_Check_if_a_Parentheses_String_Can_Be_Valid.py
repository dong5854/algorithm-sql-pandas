from collections import deque


class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        if len(s) % 2 == 1:
            return False

        unlocked = deque()
        opened = deque()

        for i in range(len(s)):
            if locked[i] == "0":
                unlocked.append(i)
            elif s[i] == "(":
                opened.append(i)
            elif s[i] == ")":
                if opened:
                    opened.pop()
                elif unlocked:
                    unlocked.pop()
                else:
                    return False

        print(opened, len(opened))
        print(unlocked, len(unlocked))

        while opened and unlocked and opened[-1] < unlocked[-1]:
            opened.pop()
            unlocked.pop()

        if opened:
            return False

        return True
