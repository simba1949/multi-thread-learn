# Java 多线程之Lock的使用

* ReentrantLock
* ReentrantReadWriteLock

## ReentrantLocak

在 Java 多线程中，可以使用 synchronized 关键字来实现线程之间同步互斥，但是在 JDK 1.5 中添加 ReenstrantLock 类也能达到同样的效果，并且在扩展功能上更加强大，比如具有嗅探锁定、多路分支通知等功能，而且使用上也比 synchronized 更加灵活。

调用 lock.lock() 代码的线程就持有了“对象监视器”，其他线程只能等待锁被释放时再次抢夺。

关键字 synchronized 与 wait() 和 notify() / notifyAll() 方法相结合可以实现等待/通知模式，类 ReentrantLock 也可以实现相同的功能，需要借助 Condition 对象。 Condition 使用更加灵活，可以实现多路通知功能，也就是说一个 Lock 对象里面可以创建多个 Condition 实例即对象监听器，线程对象可以注册在指定的 Condition 中，从而可以有选择性的进行线程通知，在调度线程上更加灵活。

在使用 notify / notifyAll 方法进行通知时，被通知的线程却是由 JVM 随机选择的。但是用 ReentrantLock 结合 Condition 类是可以实现“选择性通知”，这个功能是非常重要的，而且在 Condition 类中默认提供。

而 synchronized 就相当于整个 Lock 对象中只有一个单一的 Condition 对象，所有的线程都注册在它一个对象的身上。线程从 notifyAll 时，需要通知所有的 waiting 线程，没有选择权，会出现相当大的效率问题。

必须在 condition.await() 方法调用之前调用 lock.lock() 代码获取同步监视器。

### 实现等待 / 通知模式

Object 类中的 wait() 方法相当于 Condition 类中的 await() 方法；

Object 类中的 wait(long timeout) 方法相当于 Condition 类中的 await(long time, TimeUnit unit) 方法；

Object 类中的 notify() 方法相当于 Condition 类中的 signal() 方法；

Object 类中的 notifyAll() 方法相当于 Condition 类中的 signalAll() 方法。

#### 简单等待/通知模式

##### 服务类

```java
package top.simba1949.waitandnofity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SIMBA1949
 * @date 2019/8/8 16:39
 */
public class ReentrantLock03 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod(){
        try {
            lock.lock();
            System.out.println("wait time is " + System.currentTimeMillis());
            // 线程阻塞等待
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalMethod(){
        try {
            lock.lock();
            System.out.println("signal time is " + System.currentTimeMillis());
            // 线程通知/唤醒
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
```

##### 线程类

```java
package top.simba1949.waitandnofity;

/**
 * @author SIMBA1949
 * @date 2019/8/8 16:42
 */
public class Thread03 extends Thread {
    private ReentrantLock03 service;

    public Thread03(ReentrantLock03 service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMethod();
    }
}
```

##### 测试类

```java
package top.simba1949.waitandnofity;

/**
 * @author SIMBA1949
 * @date 2019/8/8 16:43
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock03 service = new ReentrantLock03();
        new Thread03(service).start();
        Thread.sleep(3000);
        service.signalMethod();
    }
}
```

### 公平锁与非公平锁

公平锁：表示线程获取锁的顺序是按照线程加锁的顺序来分配的，即先来先得的 FIFO 先进先出顺序。

非公平锁：是一种获取锁的抢占机制，是随机获得锁的，和公平锁不一样的就是先来的不一定先得到锁，这个方式可能造成某些线程一直拿不到锁，结果也就不公平啦。

### 方法

#### Lock 

* lock.lockInterruptibly() ：如果当前线程未被中断，则获得此锁，如果已经中断则出现异常；
* lock.tryLock() ：仅在调用时锁定未被另一个线程保持情况下，才获得该锁；
* lock.tryLock(long time, TimeUnit unit) ：如果锁在给定等待时间范围内没有被另一个线程保持，且当前线程未被中断，则获取该锁；

#### ReentrantLock

* lock.getHoldCount() ：查询当前线程保持此锁的个数，也就是调用 lock.lock() 的次数；
* lock.getQueueLength() ：返回正在等待获取此锁的线程估计数，也就说有多少个线程等待 lock 的释放；
* lock.getWaitQueueLength(Condition condition) ：返回等待与此锁相关的给定条件 Condition 的线程估计数。比如：有 5 个线程，每个线程都执行了同一个 condition 对象的 await() 方法，则调用 lock.getWaitQueueLength(condition) 方法时返回的 int 的值是 5；
* lock.hasQueuedThread(Thread thread) ：查询指定的是线程是否正在等待获取此锁；
* lock.hasQueuedThreads() ：查询是否有线程正在等待获取此锁；
* lock.hasWaiters(Condition condition) ：查询是否有线程正在等待与此锁有关的 condition 条件；
* lock.isFair() ：判断该锁是否是公平锁；
* lock.isHeldByCurrentThread() ：查询当前线程是否持有该锁；
* lock.isLocked() ：查询该锁是否被占用锁定；

#### Condition

* awaitUninterruptibly() ：线程在调用 condition.await() 后处于await状态，此时调用 thread.interrupt() 会报错
  但是使用 condition.awaitUninterruptibly() 后，调用 thread.interrupt() 则不会报错
* awaitUntil(Date deadline) ： 在等待时间之内可以被其它线程唤醒，等待时间一过该线程会自动唤醒，和别的线程争抢锁资源

## ReentrantReadWriteLock

在类 ReentrantLock 具有完全互斥排他的效果，即同一时间只有一个线程在执行 ReentrantLock.lock() 方法后面的任务。这样做虽然保证了实例变量的线程安全性，但效率却很低下。所以 JDK 提供了 ReentrantReadWriteLock 类，使用它可以加快运行效率，在某些不需要操作实例变量的方法中，完全可以使用读写锁 ReentrantReadWriteLock 来提升该方法的代码运行速度。

读写锁表示两个锁，一个是读操作相关的锁，也称为共享锁；另一个是写操作相关的锁，也叫排它锁。也就是多个读锁之间不互斥，读锁与写锁互斥，写锁与写锁互斥。在没有线程进行写入操作时，进行读取操作的多个线程可以获取读锁，而进行写入操作的线程只有在获取写锁才能进行写入操作。即多个线程可以进行读操作，但是同一时刻只允许一个线程进行写操作。

### 读读共享锁

```java
package top.simba1949.readreadlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author SIMBA1949
 * @date 2019/8/10 10:17
 */
public class ReadAndReadLockService {
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void read(){
        try {
            // 获取读锁
            reentrantReadWriteLock.readLock().lock();
            System.out.println("BEGIN : the thread  what get read lock name is " + Thread.currentThread().getName() + "\tnow " + System.currentTimeMillis());
            Thread.sleep(30000);
            System.out.println("END : the thread  what get read lock name is " + Thread.currentThread().getName() + "\tnow " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放读锁
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}
```

### 读写互斥锁

```java
package top.simba1949.readwriterlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author SIMBA1949
 * @date 2019/8/10 10:27
 */
public class ReadAndWriteLockService {
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void read(){
        try {
            reentrantReadWriteLock.readLock().lock();
            System.out.println("READ : the current thread name is " + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    public void write(){
        try {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println("WRITE : the current thread name is " + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }
}
```

### 写写互斥

### 写读互斥

