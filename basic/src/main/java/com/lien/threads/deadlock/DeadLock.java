package com.lien.threads.deadlock;

/**
 * deal lock 测试
 */
public class DeadLock {

    public static void main(String[] args) {
        Object signalA = new Object();
        Object signalB = new Object();
        ThreadA threadA = new ThreadA(signalA, signalB);
        ThreadB threadB = new ThreadB(signalA,signalB);
        Thread a = new Thread(threadA);
        Thread b = new Thread(threadB);
        a.start();
        b.start();
    }
}


class ThreadA implements Runnable{

    private Object signalA;

    private Object signalB;

    public ThreadA(Object signalA, Object signalB){
        this.signalA = signalA;
        this.signalB = signalB;
    }

    @Override
    public void run() {
        synchronized (signalA){
            try {
                System.out.println("ThreadA 获得 A锁");
                Thread.sleep(500);
                synchronized (signalB){
                    System.out.println("ThreadA 获得 B锁");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadB implements Runnable{

    private Object signalA;

    private Object signalB;

    public ThreadB(Object signalA, Object signalB){
        this.signalA = signalA;
        this.signalB = signalB;
    }

    @Override
    public void run() {
        synchronized (signalB){
            try {
                System.out.println("ThreadB 获得 B锁");
                Thread.sleep(500);
                synchronized (signalA){
                    System.out.println("ThreadB 获得 A锁");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}