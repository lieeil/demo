package com.lien.sync;

public class SyncTest {

    public static void main(String[] args){
        synchronized (SyncTest.class){
            System.out.println("SyncTest");
        }
    }

}
