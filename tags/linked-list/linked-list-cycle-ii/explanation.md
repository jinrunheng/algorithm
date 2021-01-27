## 142. 环形链表 II

[142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

#### 解题思路：双指针

本题在我的简书文章[《链表相关基础题及答案解析》](https://www.jianshu.com/p/493614feadef)中有详细的图示解析

思路：

设置一个快指针和慢指针，最开始的时候，将快，慢指针都指向链表头部

快指针每次走两步，慢指针每次走一步

如果，快指针随着移动指向了`null`，说明链表无环

否则，说明链表有环，快指针迟早会和慢指针重合

对于一个成环链表，存在这样的规律：

快指针和慢指针重合时，将快指针移回到链表头节点，改成快指针和慢指针均一次走一步；当快指针和慢指针再次相遇时，两个指针共同指向的节点即为入环的第一个节点

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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != fast){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // or return fast
    }
}
```

