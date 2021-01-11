/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode cur = new ListNode(-1);
        ListNode dummy = cur;
        
        while(p1 != null &&  p2 != null){
            if(p1.val <= p2.val){
                cur.next = p1;
                p1 = p1.next;
                cur = cur.next;
            }else {
                cur.next = p2;
                p2 = p2.next;
                cur = cur.next;
            }
        }
        while(p1 != null){
            cur.next = p1;
            break;
        }
        while(p2 != null){
            cur.next = p2;
            break;
        }
        return dummy.next;
    }
}