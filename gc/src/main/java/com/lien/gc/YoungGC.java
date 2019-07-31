package com.lien.gc;

/**
 * Description: YoungGc <br>
 *
 * @author li
 */
public class YoungGC {

    public static void main(String[] args) throws InterruptedException {
        byte[] bytes = new byte[4*1024*1024];
        for(;;){
            Thread.sleep(500);
            bytes = new byte[4*1024*1024];
        }
    }

}
