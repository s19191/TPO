/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad4;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {

    String host;
    int port;
    String id;
    SocketChannel server;

    public Client(String host, int port, String id) {
        this.host = host;
        this.port = port;
        this.id = id;
    }

    public void connect(){
        try {
            server = SocketChannel.open();
            server.connect(new InetSocketAddress(host,port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String send(String req){
        return null;
    }

}