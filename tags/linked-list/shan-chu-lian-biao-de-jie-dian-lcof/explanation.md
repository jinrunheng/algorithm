## 剑指 Offer 18. 删除链表的节点

[剑指 Offer 18. 删除链表的节点](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/)

#### 解题思路：链表的处理小技巧，使用虚拟头节点

在链表题目中，有一种处理技巧，就是在头节点前增加一个“虚拟“头节点,让这个虚拟头节点的`next`指针指向真正的头节点

本题中，我们要删除一个节点，需要知道这个被删除节点的前一个节点

我们需要分两种情况：

1. 删除的节点是头节点
2. 删除的节点不是头节点

代码如下：

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        
        if(head == null){
            return head;
        }
        // 如果删除的节点是头节点
        if(head.val == val){
            return head.next;
        }
        ListNode cur = head;
        while(cur.next != null && cur.next.val != val){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
```

这样就会导致思考的逻辑复杂；在本题中，如果删除的节点是头节点，我们只需要`return head.next;`这样处理即可；可是如果遇到复杂的逻辑，我们可能要写很长的代码。

在链表的问题中，如果遇到类似的需要对头节点和其他部分分开处理的情况时，最常用的手段就是在头节点前面加一个虚拟头节点；这样就可以方便我们将本来需要分开考虑的逻辑划一。

#### 代码

*Java*

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(cur.next != null && cur.next.val != val){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }
}
```

