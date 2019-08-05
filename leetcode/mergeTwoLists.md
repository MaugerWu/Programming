## LeetCode_21

- [LeetCode-21.合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)


```
将两个有序链表合并为一个新的有序链表并返回。
新链表是通过拼接给定的两个链表的所有节点组成的。
```

示例：

```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

示例代码：

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
        
    }
}
```

## 方法一：使用递归题解

- 测试用例：208个
- 执行用时：1ms
- 内存消耗：35.9MB
- 时间复杂度：O(min(n, m))
- 空间复杂度：O(n+m)

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
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
```

## 方法二：使用迭代方法题解

- 测试用例：208个
- 执行用时：1ms
- 内存消耗：36.3MB
- 时间复杂度：O(n+m))
- 空间复杂度：O(1)

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
        // 设置一个哨兵节点
        ListNode preHead = new ListNode(-1);
        // 指针
        ListNode prev = preHead;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
```
