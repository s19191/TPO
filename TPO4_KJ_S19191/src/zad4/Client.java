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
import java.nio.charset.StandardCharsets;

public class Client {

    String host;
    int port;
    String id;
    SocketChannel server;
    InetSocketAddress client;
    ByteBuffer buffer;

    public Client(String host, int port, String id) {
        this.host = host;
        this.port = port;
        this.id = id;
        client = new InetSocketAddress(host,port);
        buffer = ByteBuffer.allocate(1024);
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
        String response = "";
        try
        {
            server.write(StandardCharsets.UTF_8.encode(id + "_" + req));
            server.read(buffer);
            buffer.flip();
            response += (StandardCharsets.UTF_8.decode(buffer));
            buffer.clear();
        }
        catch (IOException ignored){}
        return response;
    }
}