# LeetCode-70

- [LeetCode_70.爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

```
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。
```

示例 1：

```
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
```

示例 2：

```
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
```

示例代码：

```java
class Solution {
    public int climbStairs(int n) {
        
    }
}
```

# Solution

## 方法一：递归题解

- 不通过，原因是超出时间限制

```java
class Solution {
    public int climbStairs(int n) {
        if (n < 3) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
```

```java
class Solution {
    public int climbStairs(int n) {
      return climbStairs(0, int n);
    }
    
    public int climbStairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }
}
```

## 方法二：动态规划题解

- 测试用例：45个（1~45）
- 执行用时：1ms
- 内存消耗：33.4MB
- 时间复杂度：O(n)
- 空间复杂度：O(1)

```java
class Solution {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int a = 1, b = 2, c;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
```

- 测试用例：45个（1~45）
- 执行用时：1ms
- 内存消耗：33.2MB
- 时间复杂度：O(n)
- 空间复杂度：O(n)

```java
class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```

## 方法三：斐波那契公式题解

![](https://gss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D600%2C800/sign=2c04bf8f174c510fae91ea1c50690915/b21bb051f81986189d3a8ec347ed2e738bd4e67c.jpg)

- 测试用例：45个（1~45）
- 执行用时：1ms
- 内存消耗：33.6MB
- 时间复杂度：O(log(n))，Math.pow(double a, double b) 方法将会用去 log(n) 的时间
- 空间复杂度：O(n)

```java
class Solution {
    public int climbStairs(int n) {
    	double sqrt5 = Math.sqrt(5);
    	double fibN = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
    	return (int) (fibN / sqrt5);
}
```
