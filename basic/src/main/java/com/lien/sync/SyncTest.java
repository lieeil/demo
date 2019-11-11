package com.lien.sync;

public class SyncTest {

    public static void main(String[] args){
        SyncTest syncTest = new SyncTest();
        synchronized (syncTest){
            System.out.println("a");
        }
    }

}
