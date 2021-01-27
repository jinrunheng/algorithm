## 141. 环形链表

[141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

#### 解题思路：快慢指针

我们设定一个慢指针和快指针，它们最开始都指向链表头部

慢指针一次走一步，快指针一次走两步

如果一个链表有环：

- 快指针和慢指针一定会重合

如果该链表无环：

- 那么快指针终究会指向`null`

#### 代码

*Java*

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 使用快慢指针
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != fast){
            if(fast.next == null || fast.next.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
```

