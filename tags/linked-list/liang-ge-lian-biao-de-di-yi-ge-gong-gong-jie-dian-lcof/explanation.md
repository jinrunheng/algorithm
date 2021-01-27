## 剑指 Offer 52. 两个链表的第一个公共节点

[剑指 Offer 52. 两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)

#### 解题思路：常规解法

常规思路：

1. 如果`headA`为`null`或者是`headB`为`null`,直接返回`null`
2. 对链表`A`遍历至尾部获取链表`A`的长度和链表`A`的为尾节点
3. 对链表`B`遍历至尾部获取链表`B`的长度和链表`B`的为尾节点
4. 如果链表`A`的尾节点和链表`B`的尾节点不同，说明两个链表不相交，直接返回`null`
5. 否则说明两链表必然相交，比较链表`A`的长度和链表`B`的长度，哪个长就让哪一个先走
6. 长链表走到和短链表一样长的时候，两个链表再同时走，返回两个链表相交的第一个节点即可

#### 代码

*Java*

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        // 两个相交链表 必然满足：链表的最后一个节点是同一个节点
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 1;
        int lenB = 1;
        while(curA.next != null){
            curA = curA.next;
            lenA++;
        }
        while(curB.next != null){
            curB = curB.next;
            lenB++;
        }
        if(curA != curB){
            return null;
        }
        // 否则一定相交
        int pass = 0;
        if(lenA > lenB){
            pass = lenA - lenB;
        }else {
            pass = lenB - lenA;
        }
        if(lenA > lenB){
            for(int i = 0; i < pass; i++){
                headA = headA.next;
            }
        }else {
            for(int i = 0; i < pass; i++){
                headB = headB.next;
            }
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA; // or return headB
    }
}
```

#### 解题思路：双指针的奇妙相会

参考题解：[【图解 双指针法，浪漫相遇】](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/)

分别使用两个指针`node1`和`node2`分别指向两个链表`headA`和`headB`的头节点

然后对两个链表逐个节点遍历

> 当 `node1` 到达链表` headA` 的末尾时，重新定位到链表` headB `的头结点；当 `node2 `到达链表 `headB `的末尾时，重新定位到链表 `headA` 的头结点。
>
> 这样，当它们相遇时，所指向的结点就是第一个公共结点。
>
> 作者：z1m
> 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/
> 来源：力扣（LeetCode）
> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

#### 代码

*Java*

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while(node1 != node2){
            if(node1 != null){
                node1 = node1.next;
            }else {
                node1 = headB;
            }

            if(node2 != null){
                node2 = node2.next;
            }else {
                node2 = headA;
            }
        }
        return node1; // or return node2
    }
}
```

