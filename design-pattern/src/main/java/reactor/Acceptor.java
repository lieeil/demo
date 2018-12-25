package reactor;

import java.io.IOException;
import java.nio.channels.SocketChannel;

/**
 * Description: <br>
 *
 * @author li
 * @date 2018-12-25 19:00
 */
public class Acceptor implements Runnable {

    private Reactor reactor;

    public Acceptor(Reactor reactor){
        this.reactor = reactor;
    }

    @Override
    public void run() {
        try{
            SocketChannel socketChannel = reactor.serverSocketChannel.accept();
            if(socketChannel != null){
                new SocketReadHandler(reactor.selector, socketChannel);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
