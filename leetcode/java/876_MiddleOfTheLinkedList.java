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
// /*
//  * 처음 한 풀이 시간 복잡도 O(N) + O(N/2)
//  */
// class Solution {
//     public ListNode middleNode(ListNode head) {
//         int cnt = 0;
//         ListNode temp = head;
//         while (temp != null) {
//             cnt++;
//             temp = temp.next;
//         }

//         int mid = cnt / 2 + 1;
//         ListNode node = head;
//         for (int i = 1; i < mid; i++) {
//             node = node.next;
//         }
//         return node;
//     }
// }
/*
 * Fast and Slow Pointer 를 사용한 풀이 시간 복잡도가 O(N)으로 위에보다 효율적이다.
 */
class Solution {
    public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
    }
}