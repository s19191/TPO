/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad4;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server{

    String host;
    int port;
    Selector selector;
    ServerSocketChannel serverChannel;
    InetSocketAddress serverAddress;
    ByteBuffer bufferRead;
    ExecutorService executorService;
    Map<String, List<String>> clogs;
    List<String> serverLog;
    boolean isRunning;

    public Server(String host, int port){
        this.host = host;
        this.port = port;
        serverAddress = new InetSocketAddress(host,port);
        bufferRead = ByteBuffer.allocate(1024);
        executorService = Executors.newSingleThreadExecutor();
        clogs = new LinkedHashMap<>();
        serverLog = new ArrayList<>();
    }

    public void startServer() {
        isRunning = true;
        try {
            selector = Selector.open();
            serverChannel = ServerSocketChannel.open();
            serverChannel.bind(serverAddress);
            serverChannel.configureBlocking(false);
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            executorService.execute(() -> {
                try {
                    while (isRunning) {
                        this.loop();
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        executorService.shutdownNow();
        isRunning = false;
    }

    String getServerLog(){
        String result = "";
        for (int i = 0; i < serverLog.size(); i++) {
            result += serverLog.get(i) + "\n";
        }
        return result;
    }

    void loop() throws Throwable {
        selector.select();
        Set<SelectionKey> selectedKeys = selector.selectedKeys();
        Iterator<SelectionKey> iter = selectedKeys.iterator();
        while (iter.hasNext()) {
            SelectionKey key = iter.next();
            if (!key.isValid()) {
                continue;
            }
            if (key.isAcceptable()) {
                SocketChannel client = serverChannel.accept();
                if (client != null) {
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                }
            }
            if (key.isReadable()) {
                SocketChannel client = (SocketChannel) key.channel();
                client.read(bufferRead);
                bufferRead.flip();
                String whatReaded = StandardCharsets.UTF_8.decode(bufferRead).toString();
                bufferRead.clear();
                String[] tmp = whatReaded.split("_");
                String clientId = tmp[0];
                if (!clogs.containsKey(clientId)) {
                    List<String> tmpList = new ArrayList<>();
                    tmpList.add("=== " + clientId + " log start ===");
                    clogs.put(clientId, tmpList);
                }
                String req = tmp[1];
                String[] tmp1 = req.split(" ");
                String ans = "";
                String serverLogInfo = "";
                LocalDateTime ldnow = LocalDateTime.now();
                String nowFormat = "HH:mm:ss.SSS";
                String timeNow = ldnow.format(DateTimeFormatter.ofPattern(nowFormat));
                if (tmp1.length == 1) {
                    switch (req) {
                        case "bye": {
                            ans = "logged out";
                            serverLogInfo = clientId + " logged out at " + timeNow;
                            clogs.get(clientId).add(ans);
                            serverLog.add(serverLogInfo);
                            client.write(StandardCharsets.UTF_8.encode(ans));
                            break;
                        }
                        default: {
                            ans = "Nie znana komenda";
                            serverLogInfo = clientId + " Nie znana komenda at " + timeNow;
                            clogs.get(clientId).add(ans);
                            serverLog.add(serverLogInfo);
                            client.write(StandardCharsets.UTF_8.encode(ans));
                            break;
                        }
                    }
                } else {
                    switch (tmp1[0]) {
                        case "login": {
                            ans = "logged in";
                            serverLogInfo = clientId + " logged in at " + timeNow;
                            clogs.get(clientId).add(ans);
                            serverLog.add(serverLogInfo);
                            client.write(StandardCharsets.UTF_8.encode(ans));
                            break;
                        }
                        case "bye": {
                            if (req.equals("bye and log transfer")) {
                                serverLogInfo = clientId + " logged out at " + timeNow;
                                serverLog.add(serverLogInfo);
                                clogs.get(clientId).add("logged out");
                                clogs.get(clientId).add("=== " + clientId + " log end ===");
                                for (String s : clogs.get(clientId)) {
                                    ans += s + "\n";
                                }
                                client.write(StandardCharsets.UTF_8.encode(ans));
                            } else {
                                ans = "Nie znana komenda";
                                serverLogInfo = clientId + " Nie znana komenda at " + timeNow;
                                clogs.get(clientId).add(ans);
                                serverLog.add(serverLogInfo);
                                client.write(StandardCharsets.UTF_8.encode(ans));
                            }
                            break;
                        }
                        default: {
                            ans = Time.passed(req.split(" ")[0],req.split(" ")[1]);
                            clogs.get(clientId).add("Request: " + req);
                            clogs.get(clientId).add("Result:");
                            serverLogInfo = clientId + " request at " + timeNow + ": \"" + req + "\"";
                            clogs.get(clientId).add(ans);
                            serverLog.add(serverLogInfo);
                            client.write(StandardCharsets.UTF_8.encode(ans));
                            break;
                        }
                    }
                }
            }
            iter.remove();
        }
    }
}