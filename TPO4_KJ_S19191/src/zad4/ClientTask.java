/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad4;


import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ClientTask extends FutureTask<String> {
    Client c;
    List<String> reqs;
    boolean showSendRes;
    volatile String log;

    public ClientTask(Callable<String> callable) {
        super(callable);
    }

    public static ClientTask create(Client c, List<String> reqs, boolean showSendRes){
        Callable<String> callable = () -> {
            c.connect();
            String log = "";
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
            return log;
        };
        return new ClientTask(callable);
    }

    public String get() throws InterruptedException, ExecutionException {
        return null;
    }
}