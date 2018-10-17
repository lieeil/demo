package com.lien.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: <br>
 *
 * @author li
 * @date 2018/10/16 下午7:47
 */
public class ThreadExecutorService {

    private static AtomicInteger index = new AtomicInteger(0);

    public static ExecutorService createPool(){
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("thread--" + index.getAndIncrement());
                return thread;
            }
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor(threadFactory);
        return executorService;
    }

    public static void main(String[] args){
        List<Product> productList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Product product = new Product();
            product.setId(i);
            product.setName("第" + i + "个");
            product.setDesc("第" + i + "个");
            productList.add(product);
        }
        List<Future> futures = new ArrayList<>();
        for(Product product : productList){
            Future future = ThreadExecutorService.createPool().submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("休眠前:" + Thread.currentThread().getName() + " id="
                          + product.getId() + " name=" +product.getName()
                          + " desc=" + product.getDesc());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("休眠后:" + Thread.currentThread().getName() + " id="
                            + product.getId() + " name=" +product.getName()
                            + " desc=" + product.getDesc());
                }
            });
            futures.add(future);
        }
    }

}
