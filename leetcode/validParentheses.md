## LeetCode-20

- [LeetCode_20.有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

```
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
```

示例 1：

```
输入: "()"
输出: true
```

示例 2:

```
输入: "()[]{}"
输出: true
```

示例 3:

```
输入: "(]"
输出: false
```

示例 4:

```
输入: "([)]"
输出: false
```

示例 5:

```
输入: "{[]}"
输出: true
```

示例代码：

```java
class Solution {
    public boolean isValid(String s) {
        
    }
}
```

## 方法一：利用 string.contains() 与 string.replace() 方法题解

- 测试用例：76个
- 执行用时：184ms
- 内存消耗：65MB

```java
class Solution {
    public boolean isValid(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            if (s.contains("{}")) s = s.replace("{}", "");
            if (s.contains("()")) s = s.replace("()", "");
            if (s.contains("[]")) s = s.replace("[]", "");
        }
        return s.isEmpty();
    }
}
```

## 方法二：利用栈 Stack 题解

- 测试用例：76个
- 执行用时：7ms
- 内存消耗：34.6MB

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if (c == '}' && top != '{') {
					return false;
				}
				if (c == ')' && top != '(') {
					return false;
				}
				if (c == ']' && top != '[') {
					return false;
				}
			}
		}
		return stack.isEmpty();
    }
}
```
