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
    public ListNode deleteMiddle(ListNode head) {
        int cnt = 1;
        for(ListNode temp = head; temp.next != null; temp = temp.next) {
            cnt++;
        }

        if (cnt == 1) {
            return null;
        }

        int removeIdx = cnt / 2;

        ListNode beforeRemove = head;
        for (int idx = 0; idx < removeIdx - 1; idx++) {
            beforeRemove = beforeRemove.next;
        }

        beforeRemove.next = beforeRemove.next.next;
        return head;
    }
}