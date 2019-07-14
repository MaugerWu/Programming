# LeetCode-cn_509

- [509.斐波那契数](https://leetcode-cn.com/problems/fibonacci-number/)

```
斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
也就是：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
给定 N，计算 F(N)。
```

示例 1：

```
输入：2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
```

示例 2：

```
输入：3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
```

示例 3：

```
输入：4
输出：3
解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
```

提示：

```
0 ≤ N ≤ 30
```

# Solution

## 方法一：递归方法题解

- 测试用例：31（0~30）
- 执行用时：18ms
- 内存消耗：33.4MB

```java
class Solution {
    public int fib(int N) {
        if (N < 2) return N;
        return fib(N-1) + fib(N-2);
    }
}
```

## 方法二：动态编程方法题解

- 测试用例：31（0~30）
- 执行用时：1ms
- 内存消耗：33.8MB

```java
class Solution {
    public int fib(int N) {
        if (N < 2) return N;
        int[] fib = new int[N+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= N; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[N];
    }
}
```

## 方法三：矩阵幂方法题解

- 测试用例：31（0~30）
- 执行用时：1ms
- 内存消耗：33.5MB

```java
class Solution {
    public int fib(int N) {
        if (N < 2) return N;
		int F[][] = new int[][] { { 1, 1 }, { 1, 0 } };
		power(F, N - 1);
		return F[0][0];
    }
    
    void power(int F[][], int N) {
		int M[][] = new int[][] { { 1, 1 }, { 1, 0 } };
		for (int i = 2; i <= N; i++) {
			mutiply(F, M);
		}
	}
    
    void mutiply(int F[][], int M[][]) {
		int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
		int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
		int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
		int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];
		
		F[0][0] = x;
		F[0][1] = y;
		F[1][0] = z;
		F[1][1] = w;
	}
}
```

## 方法四：优化空间复杂度为 O(1) 题解

- 测试用例：31（0~30）
- 执行用时：0ms
- 内存消耗：33.3MB

```java
class Solution {
    public int fib(int N) {
        if (N < 2) return N;
        int a = 0, b = 1, c;
        for (int i = 2; i <= N; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
```
