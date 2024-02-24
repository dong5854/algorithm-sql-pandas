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

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode ans = new ListNode(-1);
      ListNode pointer = ans;
      int pass = 0;
      while(true) {
          int temp = pass;
          if (l1 == null && l2 == null) break;
          if (l1 != null) {
              temp += l1.val;
              l1 = l1.next;
          }
          if (l2 != null) {
              temp += l2.val;
              l2 = l2.next;
          }
          pass = temp / 10;
          pointer.next = new ListNode(temp%10);
          pointer = pointer.next;
      }
      if (pass > 0) {
          pointer.next = new ListNode(pass);
          pointer = pointer.next;
      }

      return ans.next;
  }
}