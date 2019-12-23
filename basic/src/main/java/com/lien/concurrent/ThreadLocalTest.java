package com.lien.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Description: <br>
 *
 * @author li
 * @date 2019-11-13 20:08
 */
public class ThreadLocalTest {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private ThreadLocal<String> threadLocal2 = new ThreadLocal<>();


    public void start() {
        for (int i=0; i<1; i++) {
            int finalI = i;
            new Thread(() -> {
                threadLocal.set(finalI);
                threadLocal2.set(" threadLocal2 " );
            }).start();
        }
    }

    public static void main(String[] args){

        ArrayList[] list = new ArrayList[2];
        ArrayList<Long> a1 = new ArrayList<Long>();
        a1.add(1L);
        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("哈哈哈哈哈哈哈");
        list[0] = a1;
        list[1] = a2;
        System.out.println(list[0]);
        System.out.println(list[1]);
    }

}

