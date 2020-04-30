/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad4;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Client {

    String host;
    int port;
    String id;
    SocketChannel server;
    InetSocketAddress client;
    ByteBuffer bufferRead;
    Charset charset = Charset.forName("UTF-8");

    public Client(String host, int port, String id) {
        this.host = host;
        this.port = port;
        this.id = id;
        client = new InetSocketAddress(host,port);
        bufferRead = ByteBuffer.allocate(1024);
    }

    public void connect(){
        try {
            server = SocketChannel.open();
            server.connect(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String send(String req){
        String result = "";
        try {
            server.write(charset.encode(id + "_" + req));
            server.read(bufferRead);
            bufferRead.flip();
            result += (charset.decode(bufferRead));
            bufferRead.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}