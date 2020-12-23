## 剑指 Offer 24. 反转链表

[剑指 Offer 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

#### 解题思路一：迭代法反转链表

双指针迭代法是反转链表最经典的解法，比起描述思路，读者不如尝试看代码，自己在纸上画一画变量指向的关系，很快就会豁然开朗

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
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
```

#### 解题思路二：递归法反转链表

递归的过程实际上比迭代要难以理解；初步接触递归只需要记住两点：

1. 递归的*base case*，也就是递归触底的返回值
2. 宏观考虑递归调用,分析子过程的结果与递归调用外的数据的联系

示例：现有链表

```
5 -> 4 -> 3 -> 2 -> 1 -> NULL
```



我们知道：调用函数`reverseList(head)` 后，链表的结果为：

```
1 -> 2 -> 3 -> 4 -> 5 -> NULL
```

分析子过程,如果调用`reverseList(head.next)`,那么结果即为：

```
5 -> 4 <- 3 <- 2 <- 1
```

所以，我们也就能知道`reverseList(head)`和子过程`reverseList(head.next)`的转换关系，代码也就可以写出来了

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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
```

#### 解题思路三：栈

既然是反转链表，我们就很容易想到利用栈这种`LIFO`的数据结构来解决问题；整体思路也不难，详见代码

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
```



