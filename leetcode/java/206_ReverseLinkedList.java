// https://leetcode.com/problems/reverse-linked-list/description/?envType=study-plan&id=algorithm-i
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
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode temp = head.next;
        head.next = null;
        while (temp != null) {
            ListNode t =temp.next;
            temp.next = head;
            head = temp;

            temp = t;
        }
        return head;
    }
}

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
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if(head == null || head.next == null) return head;
//         ListNode ans = null;
//         while(head != null) {
//             ListNode node = head;
//             head = head.next;
//             node.next = ans;
//             ans = node;
//         }

//         return ans;
//     }
// }