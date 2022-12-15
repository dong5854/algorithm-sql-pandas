// https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=study-plan&id=algorithm-i
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        
        
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.val = list2.val;
                list2 = list2.next;
            } else {
                cur.val = list1.val;
                list1 = list1.next;
            }
            if (list1 == null) {
                cur.next = list2;
                break;
            }
            else if(list2 == null){
                cur.next = list1;
                break;
            }
            cur.next = new ListNode();
            cur = cur.next;
        }

        return head;
    }
}