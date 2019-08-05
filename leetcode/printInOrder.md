## LeetCode_1114

- [LeetCode-1114.按顺序打印](https://leetcode-cn.com/problems/print-in-order/)


我们提供了一个类：

```
public class Foo {
    public void one() { print("one"); }
    public void two() { print("two"); }
    public void three() { print("three"); }
}
```

```
三个不同的线程将会共用一个 Foo 实例。

线程 A 将会调用 one() 方法
线程 B 将会调用 two() 方法
线程 C 将会调用 three() 方法
请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，
three() 方法在 two() 方法之后被执行。
```

示例 1:

```
输入: [1,2,3]
输出: "onetwothree"
解释: 
有三个线程会被异步启动。
输入 [1,2,3] 表示线程 A 将会调用 one() 方法，
线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
正确的输出是 "onetwothree"。
```

示例 2:

```
输入: [1,3,2]
输出: "onetwothree"
解释: 
输入 [1,3,2] 表示线程 A 将会调用 one() 方法，
线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
正确的输出是 "onetwothree"。
```

注意:

```
尽管输入中的数字似乎暗示了顺序，
但是我们并不保证线程在操作系统中的调度顺序。
你看到的输入格式主要是为了确保测试的全面性。
```

示例代码：

```java
class Foo {

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
```

## 方法一：使用锁题解

- 测试用例：36个
- 执行用时：17ms
- 内存消耗：35.8MB

```java
class Foo {

    // 构造两道屏障
    private boolean firstFinished;
    private boolean secondFinished;
    private Object lock = new Object();
    
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        synchronized (lock) {
            while (!firstFinished) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        synchronized (lock) {
            while (!secondFinished) {
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
```

## 方法二：通过信号量题解

- 测试用例：36个
- 执行用时：19ms
- 内存消耗：36.1MB

```java
import java.util.concurrent.Semaphore;

class Foo {
    
    Semaphore A;
    Semaphore B;
    Semaphore C;

    public Foo() {
        A = new Semaphore(1);
        B = new Semaphore(0);
        C = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        A.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        B.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        B.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        C.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        C.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
```

## 方法三：使用 CountDownLatch 题解

- 测试用例：36个
- 执行用时：19ms
- 内存消耗：36MB

```java
import java.util.concurrent.CountDownLatch;

class Foo {

    CountDownLatch latch1;
    CountDownLatch latch2;
    
    public Foo() {
        latch1 = new CountDownLatch(1);
        latch2 = new CountDownLatch(2);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latch1.countDown();
        latch2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        latch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        latch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
```
