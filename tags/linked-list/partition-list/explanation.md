## 86. 分隔链表

[86. 分隔链表](https://leetcode-cn.com/problems/partition-list/)

#### 解题思路：双指针

本题思路实际上非常简单，我们只需要维护两个指针：

- `less`
- `more`

`less`指针用来标记小于`x`的节点，`more`指针用来标记大于或等于`x`的节点

遍历链表，如果当前节点值小于`x`，那么就将其加到`less`后面，否则就将其加入到`more`后面；遍历到链表最后，我们将`less`的尾部和`more`的头部相连，并能返回`less`的头部即可；在处理链表问题的时候，常见的思路就是使用`dummyHead`，即使用虚拟节点放在最前面，方便我们对链表的操作，在本题中，我们可以在`less`和`more`两个我们维护的链表前各自加一个虚拟节点：`lessHead`，`moreHead`。在遍历链表完成后，我们只需要：

```java
more.next = null;
less.next = moreHead.next;
return lessHead.next;
```

即可。

详见代码

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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode lessHead = less;
        ListNode more = new ListNode(-1);
        ListNode moreHead = more;
        while(head != null){
            if(head.val < x){
                less.next = head;
                less = less.next;
            }else {
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }
        more.next = null;
        less.next  = moreHead.next;
        return lessHead.next;
    }
}
```

