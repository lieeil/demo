package com.lien.threads.product_consumer;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Product implements Runnable {

    private final Integer MAX_SIZE = 10;

    private Queue<Integer> pools;

    public Product(Queue<Integer> pools) {
        this.pools = pools;
    }

    public void addEle() {
        synchronized (this.pools) {
            while (pools != null && pools.size() == MAX_SIZE) {
                try {
                    pools.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Integer data = new Random().nextInt();
            System.out.println("生产者放入" + data);
            pools.add(data);
            pools.notifyAll();
        }

    }

    @Override
    public void run() {
        while (true){
            addEle();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        Product productor = new Product(queue);
        Consumer consumer = new Consumer(queue);
        Thread productThread = new Thread(productor);
        Thread consumerThread = new Thread(consumer);
        productThread.start();
        consumerThread.start();
    }
}

class Consumer implements Runnable {

    private final Integer MAX_SIZE = 10;

    private Queue<Integer> pools;

    public Consumer(Queue<Integer> pools) {
        this.pools = pools;
    }

    public void popEle() {
        synchronized (this.pools) {
            while (pools == null || pools.size() == 0) {
                try {
                    pools.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费者消费" + pools.poll());
            pools.notifyAll();
        }
    }

    @Override
    public void run() {
        while (true){
            popEle();
        }
    }
}