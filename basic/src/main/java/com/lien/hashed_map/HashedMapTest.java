package com.lien.hashed_map;

/**
 * Description: <br>
 *
 * @author li
 * @date 2019-07-11 18:27
 */
public class HashedMapTest {

    private DataHandler A;

    public void M1() throws InterruptedException {
        A = new DataHandler();
        System.out.println("[" + Thread.currentThread().getName() + "]" + "初始化后     A=" +  System.identityHashCode(A));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + Thread.currentThread().getName() + "]" + "执行前A.M2() A=" + System.identityHashCode(A));
        A.M2();
    }

    public static void main(String[] args){
        HashedMapTest hashedMapTest = new HashedMapTest();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    hashedMapTest.M1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
