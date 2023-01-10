// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(head.val, true);
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null) {
            if(map.containsKey(fast.val)) {
                slow.next = fast.next;
            } else {
                map.put(fast.val, true);
                slow = slow.next;
            }
            fast = fast.next;
        }
        return head;
    }
}