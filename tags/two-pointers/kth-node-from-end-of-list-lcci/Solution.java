/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthToLast(ListNode head, int k) {
        // two pointers
        ListNode first = head;
        ListNode second = head;
        while(k-- > 0){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second.val;
    }
}