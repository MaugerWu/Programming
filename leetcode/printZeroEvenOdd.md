## LeetCode_1116

- [LeetCode-1116.打印零与奇偶数](https://leetcode-cn.com/problems/print-zero-even-odd/)


假设有这么一个类：

```java
class ZeroEvenOdd {
  public ZeroEvenOdd(int n) { ... }      // 构造函数
  public void zero(printNumber) { ... }  // 仅打印出 0
  public void even(printNumber) { ... }  // 仅打印出 偶数
  public void odd(printNumber) { ... }   // 仅打印出 奇数
}
```

```
相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：

线程 A 将调用 zero()，它只输出 0 。
线程 B 将调用 even()，它只输出偶数。
线程 C 将调用 odd()，它只输出奇数。
每个线程都有一个 printNumber 方法来输出一个整数。
请修改给出的代码以输出整数序列 010203040506... ，
其中序列的长度必须为 2n。
```

示例 1：

```
输入：n = 2
输出："0102"
说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，
最后一个线程调用 odd()。正确的输出为 "0102"。
```

示例 2：

```
输入：n = 5
输出："0102030405"
```

示例代码：

```java
class ZeroEvenOdd {
    private int n;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        
    }
}
```

## 方法一：使用信号量题解

- 测试用例：14个
- 执行用时：10ms
- 内存消耗：36.7MB

```java
import java.util.concurrent.Semaphore;

class ZeroEvenOdd {
    private int n;
    private Semaphore s1, s2, s3;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
        s3 = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            s1.acquire();
            printNumber.accept(0);
            if ((i & 1) == 0) {
                s2.release();
            } else {
                s3.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            s2.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            s3.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }
}
```
