package com.lien.threads;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Product> productList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Product product = new Product();
            product.setId(i);
            product.setName("第" + i + "个");
            product.setDesc("第" + i + "个");
            productList.add(product);
        }
        List<Future<ProductDemo>> futures = new ArrayList<>();
        for(Product product : productList){
            Future<ProductDemo> future = ThreadExecutorService.createPool().submit(new Callable<ProductDemo>() {

                public ProductDemo call() {
                    ProductDemo productDemo = new ProductDemo();
                    System.out.println("休眠前:" + Thread.currentThread().getName() + " id="
                          + product.getId() + " name=" +product.getName()
                          + " desc=" + product.getDesc());
                    product.setName(product.getName() + "+" + product.getId());
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("休眠后:" + Thread.currentThread().getName() + " id="
                            + product.getId() + " name=" +product.getName()
                            + " desc=" + product.getDesc());
                    productDemo.setId(product.getId());
                    productDemo.setName(product.getName());
                    productDemo.setDesc(product.getDesc());
                    return productDemo;
                }
            });
            futures.add(future);
        }
        List<ProductDemo> productDemoList = new ArrayList<>();
        for(Future<ProductDemo> future : futures){
            productDemoList.add(future.get());
        }
        for(ProductDemo demo : productDemoList){
            System.out.println(" id="
                    + demo.getId() + " name=" +demo.getName()
                    + " desc=" + demo.getDesc());
        }

    }

}
