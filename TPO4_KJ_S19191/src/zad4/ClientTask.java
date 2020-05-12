/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad4;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ClientTask extends FutureTask<String> {

    static Map<Client,String> logs = new HashMap<>();
    Client c;

    public ClientTask(Callable<String> callable, Client c) {
        super(callable);
        this.c = c;
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
            logs.put(c, log);
            return log;
        };
        return new ClientTask(callable, c);
    }

    public String get() throws InterruptedException, ExecutionException {
        while (!this.isDone());
        return logs.get(c);
    }
}