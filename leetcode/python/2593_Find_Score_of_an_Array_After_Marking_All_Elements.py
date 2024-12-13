class Solution:
    def findScore(self, nums: List[int]) -> int:
        sorted = [(num, idx) for idx, num in enumerate(nums)]
        sorted.sort()
        marked = [False] * len(nums)

        ans = 0
        for num, idx in sorted:
            if not marked[idx]:
                ans += num
                marked[idx] = True

                if idx - 1 >= 0:
                    marked[idx - 1] = True
                if idx + 1 < len(nums):
                    marked[idx + 1] = True

        return ans