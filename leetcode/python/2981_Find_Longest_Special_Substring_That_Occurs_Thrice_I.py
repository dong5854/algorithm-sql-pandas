class Solution:
    def maximumLength(self, s: str) -> int:
        counter = {}
        for start in range(len(s)):
            char = s[start]
            substring_length = 0
            for end in range(start, len(s)):
                if char == s[end]:
                    substring_length += 1
                    counter[char*substring_length] = counter.get(char*substring_length, 0) + 1
                else:
                    break

        ans = -1
        for key, val in counter.items():
            if val >= 3 and len(key) > ans:
                ans = len(key)
                
        return ans
        