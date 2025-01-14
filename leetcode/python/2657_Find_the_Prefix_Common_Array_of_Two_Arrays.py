class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        a_set = set()
        b_set = set()
        
        ans = []
        count = 0
        for i in range(len(A)):
            if A[i] == B[i]:
                count += 1
            else:
                a_set.add(A[i])
                b_set.add(B[i])

                if A[i] in b_set:
                    count += 1
                if B[i] in a_set:
                    count += 1

            ans.append(count)

        return ans