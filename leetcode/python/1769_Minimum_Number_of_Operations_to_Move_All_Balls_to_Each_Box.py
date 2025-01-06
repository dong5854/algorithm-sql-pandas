class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        n = len(boxes)
        answer = [0] * n
        
        balls_left_to_right = 0
        moves_left_to_right = 0
        balls_right_to_left = 0
        moves_right_to_left = 0

        for i in range(n):
            answer[i] += moves_left_to_right
            balls_left_to_right += int(boxes[i])
            moves_left_to_right += balls_left_to_right

            answer[n - 1 - i] += moves_right_to_left
            balls_right_to_left += int(boxes[n - 1 - i])
            moves_right_to_left += balls_right_to_left

        return answer

