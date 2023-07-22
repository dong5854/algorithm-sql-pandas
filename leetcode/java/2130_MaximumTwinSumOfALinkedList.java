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