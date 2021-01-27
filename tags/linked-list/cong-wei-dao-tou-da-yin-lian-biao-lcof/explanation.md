## 剑指 Offer 06. 从尾到头打印链表

[剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

#### 解题思路一：栈

使用栈，遍历链表时，将每个节点对应的`val`值存储到栈中

因为栈是一种`LIFO`的数据结构，我们依次将栈顶元素添加至返回数组`res`，直至栈清空

返回`res`

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
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int len = 0;
        while(head != null){
            stack.push(head.val);
            head = head.next;
            len++;
        }
        int[] res = new int[len];
        int i = 0;
        while(!stack.isEmpty()){
            res[i++] = stack.pop();
        }
        return res;
    }
}
```

#### 解题思路二：使用列表`List`

使用一个`List`列表，在遍历链表时，将链表每个节点的值存储在`List`中

使用

```java
Collections.reverse(list);
```

反转列表

使用`Java8`引入的`stream`将列表转换成数组

```java
list.stream().mapToInt(Integer::valueOf).toArray();
```

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
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
```

