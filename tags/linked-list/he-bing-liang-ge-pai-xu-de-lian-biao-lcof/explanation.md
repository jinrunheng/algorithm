## 剑指 Offer 25. 合并两个排序的链表

[剑指 Offer 25. 合并两个排序的链表](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)

#### 解题思路：双指针，归并排序merge的思想

因为合并的两个链表是有序的，最终要将其合并成一个整体有序的链表。

这与归并排序的`merge`思想如出一辙。

我们使用两个指针，分别指向两个有序链表的头部，比较指针指向的节点的大小，哪个小，就将其加入到返回的链表序列中，并且让指针后移。

本代码使用了解决链表问题的一种思路：使用虚拟头节点来简化逻辑操作

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
```

