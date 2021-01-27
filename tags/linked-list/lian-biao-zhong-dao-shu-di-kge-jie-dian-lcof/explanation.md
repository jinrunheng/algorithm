## 剑指 Offer 22. 链表中倒数第k个节点

[剑指 Offer 22. 链表中倒数第k个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)

#### 解题思路一：栈

比较容易想到的方式就是用栈这种数据结构

我们将原链表的节点全部压入栈，然后再将栈中最上面的`k`个节点出栈即可

原理十分简单

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
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        for(int i = 0; i < k - 1; i++){
            stack.pop();
        }
        return stack.pop();
    }
}
```



#### 解题思路二：双指针

维护两个指针`p1`,`p2`，最开始`p1`指针指向`head`，`p2`指针指向`null`

算法流程：

1. `p1`指针先向前走`k`步
2. `p1`走完`k`步以后，双指针共同移动，`p2`指向`head`,直至`p1`走完链表退出
3. 返回`p2`指向的节点，即是我们所要求得的结果

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
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = null;
        for(int i = 0; i < k; i++){
            p1 = p1.next;
        }
        p2 = head;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
```

