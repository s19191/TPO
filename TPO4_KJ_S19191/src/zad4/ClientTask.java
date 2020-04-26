/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad4;


import java.util.List;
import java.util.concurrent.ExecutionException;

public class ClientTask implements Runnable {
    Client c;
    List<String> reqs;
    boolean showSendRes;
    volatile String log;

    public static ClientTask create(Client c, List<String> reqs, boolean showSendRes){
        return new ClientTask(c,reqs,showSendRes);
    }

    public ClientTask(Client c, List<String> reqs, boolean showSendRes) {
        this.c = c;
        this.reqs = reqs;
        this.showSendRes = showSendRes;
    }

    String get() throws InterruptedException, ExecutionException {
        return null;
    }
    @Override
    public void run() {
        c.connect();
        if (showSendRes) {
            System.out.println(c.send("login " + c.id));
            for (String request : reqs) {
                System.out.println(c.send(request));
            }
            System.out.println(c.send("bye and log transfer"));
        } else {
            c.send("login " + c.id);
            for (String request : reqs) {
                c.send(request);
            }
            log = c.send("bye and log transfer");
        }
    }
}