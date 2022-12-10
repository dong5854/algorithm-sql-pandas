// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan&id=algorithm-i
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prevRemove = null;
        ListNode lastChecker = head;
        for (int i = 0; i < n; i++) {
            lastChecker = lastChecker.next;
        }

        while (lastChecker != null) {
            if (prevRemove == null) prevRemove = head;
            else prevRemove = prevRemove.next;
            lastChecker = lastChecker.next;
        }

        if (prevRemove == null) head = head.next;
        else prevRemove.next = prevRemove.next.next;

        return head;
    }
}