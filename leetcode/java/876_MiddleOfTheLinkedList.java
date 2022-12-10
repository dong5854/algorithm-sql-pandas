// https://leetcode.com/problems/middle-of-the-linked-list/description/?envType=study-plan&id=algorithm-i
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
    public ListNode middleNode(ListNode head) {
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        int mid = cnt / 2 + 1;
        ListNode node = head;
        for (int i = 1; i < mid; i++) {
            node = node.next;
        }
        return node;
    }
}