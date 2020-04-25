/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad4;


import java.io.IOException;
import java.nio.channels.*;

public class Server{
    Selector s;
    ServerSocketChannel scch

    public Server(String host, int port){
    }

    public void startServer(){
        try {
            s = Selector.open();
            scch = ServerSocketChannel.open();
            SelectionKey key = scch.register(s, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer(){
        try {
            s.close();
            scch.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getServerLog(){
        return null;
    }
}