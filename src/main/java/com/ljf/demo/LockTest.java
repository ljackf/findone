package com.ljf.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liujf05
 * @date 2019/3/18
 */
public class LockTest implements Runnable{

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args){
        LockTest lockTest = new LockTest();
        ThreadExecutorTest.e.execute(lockTest);
        lockTest.lock();
    }

    void lock (){
        lock.lock();
        System.out.println("****************************Thread:"+Thread.currentThread().getName()+"****LOCK");
        System.out.println("****************************Thread:"+Thread.currentThread().getName());
        System.out.println("****************************Thread:"+Thread.currentThread().getName()+"****UNLOCK");
        lock.unlock();
    }

    @Override
    public void run() {
       lock();
    }
}
