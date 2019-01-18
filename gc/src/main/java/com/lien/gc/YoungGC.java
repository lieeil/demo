package com.lien.gc;

/**
 * Description: YoungGc <br>
 *
 * @author li
 */
public class YoungGC {

    public static void main(String[] args) throws InterruptedException {
        YoungGC youngGC = new YoungGC();
        for(;;){
            youngGC.allocateMemory();
            Thread.sleep(5000);
        }
    }

    private void allocateMemory(){
        byte[] bytes = new byte[8*1024*1024];
    }

}
