class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1: return s
        ans = ""
        for i in range(numRows):
            for j in range(i, len(s), 2*(numRows-1)):
                ans += s[j]
                if(i > 0 and i < numRows - 1 and j + 2 * (numRows - 1) - 2 * i < len(s)):
                    ans += s[j + 2 * (numRows - 1) - 2 * i]
        return ans