/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        for(ListNode temp = head; temp != null; temp = temp.next) {
            list.add(temp);
        }
        int leftPointer = 0, rightPointer = list.size() - 1;
        int ans = 0;
        while(leftPointer < rightPointer) {
            ans = Math.max(ans, list.get(leftPointer).val + list.get(rightPointer).val);
            leftPointer++;
            rightPointer--;
        }
        return ans;
    }
}

// 다른 풀이방식
// class Solution {
//     public int pairSum(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;
//         int maxVal = 0;

//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         ListNode nextNode, prev = null;
//         while (slow != null) {
//             nextNode = slow.next;
//             slow.next = prev;
//             prev = slow;
//             slow = nextNode;
//         }

//         while (prev != null) {
//             maxVal = Math.max(maxVal, head.val + prev.val);
//             prev = prev.next;
//             head = head.next;
//         }

//         return maxVal;
//     }
// }