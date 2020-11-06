/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func kthToLast(head *ListNode, k int) int {
    first := head;
    second := head;
    for k > 0{
        first = first.Next
        k--
    }
    for first != nil{
        first = first.Next
        second = second.Next
    }
    return second.Val
}