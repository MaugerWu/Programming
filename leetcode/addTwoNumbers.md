# LeetCode_002

- [LeetCode-2.两数相加](https://leetcode-cn.com/problems/add-two-numbers/)

```
给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
```

示例：

```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    }
}
```

# Solution

- 测试用例：1563个
- 执行用时：11ms
- 内存消耗：44.7MB
- 时间复杂度：O(max(m, n))，假设 m 和 n 分别表示 l1 和 l2 的长度，上面的算法最多重复  max(m, n) 次。
- 空间复杂度：O(max(m, n))， 新列表的长度最多为  max(m, n) + max(m, n) + 1。

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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		int flag = 0;
		ListNode listNode = result;
		int x;
		while (l1 != null || l2 != null) {
			x = flag;
			if (l1 != null) {
				x += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				x += l2.val;
				l2 = l2.next;
			}
			if (x > 9) {
				flag = 1;
				x = x - 10;
			} else {
				flag = 0;
			}
			result.next = new ListNode(x);
			result = result.next;
		}
		if (flag != 0) {
			result.next = new ListNode(1);
		}
		return listNode.next;
	}
}
```
