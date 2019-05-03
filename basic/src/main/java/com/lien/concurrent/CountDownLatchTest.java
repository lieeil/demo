package com.lien.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Description: <br>
 *
 * @author li
 * @date 2019-05-03 13:28
 */
public class CountDownLatchTest implements Runnable{

    private CountDownLatch countDownLatch;

    private String name;

    public CountDownLatchTest(String name, CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        CountDownLatchTest countDown01 = new CountDownLatchTest("one", countDownLatch);
        CountDownLatchTest countDown02 = new CountDownLatchTest("two", countDownLatch);
        CountDownLatchTest countDown03 = new CountDownLatchTest("three", countDownLatch);
        CountDownLatchTest countDown04 = new CountDownLatchTest("four", countDownLatch);
        CountDownLatchTest countDown05 = new CountDownLatchTest("five", countDownLatch);

        Thread one = new Thread(countDown01);
        Thread two = new Thread(countDown02);
        Thread three = new Thread(countDown03);
        Thread fourth = new Thread(countDown04);
        Thread fifth = new Thread(countDown05);
        Long startTime = System.currentTimeMillis();
        one.start();
        two.start();
        three.start();
        fourth.start();
        fifth.start();

        countDownLatch.await();
        Long endTime = System.currentTimeMillis();
        System.out.println("all done time = " + (endTime - startTime)/1000);
    }

    @Override
    public void run() {
        try {
            Long startTime = System.currentTimeMillis();
            Random random = new Random();
            Thread.sleep(random.nextInt(5) * 1000);
            Long endTime = System.currentTimeMillis();
            System.out.println("初始化name=" + name + ", time=" + (endTime - startTime)/1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }

}
