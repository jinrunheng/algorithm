/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode tmp = null;
        if(!stack.isEmpty()){
            head = stack.pop();
            head.next = null;
            dummyHead.next = head;
        }
        while(!stack.isEmpty()){
            tmp = stack.pop();
            tmp.next = null;
            head.next = tmp;
            head = head.next;
        }
        return dummyHead.next;
    }
}