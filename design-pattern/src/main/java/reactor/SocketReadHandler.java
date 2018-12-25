package reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Description: <br>
 *
 * @author li
 * @date 2018-12-25 19:19
 */
public class SocketReadHandler implements Runnable {

    private SocketChannel socketChannel;

    public SocketReadHandler(Selector selector, SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        socketChannel.configureBlocking(false);
        SelectionKey selectionKey = socketChannel.register(selector, 0);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    @Override
    public void run() {
        ByteBuffer inputBuffer = ByteBuffer.allocate(1024);
        inputBuffer.clear();
        try{
            socketChannel.read(inputBuffer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
