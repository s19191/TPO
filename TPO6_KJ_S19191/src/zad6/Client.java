package zad6;

import javax.naming.*;
import javax.jms.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Connection con = null;
        MessageConsumer receiver;
        MessageProducer sender;
        try {
            System.out.println("Podaj nazwę urzytkownika:");
            Scanner scanner = new Scanner(System.in);
            String userName = scanner.nextLine();

            Context ctx = new InitialContext();
            ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
            String admDestName = "topic1";
            Destination dest = (Destination) ctx.lookup(admDestName);
            con = factory.createConnection();
            Session ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);

            receiver = ses.createConsumer(dest);
            con.start();
            receiver.setMessageListener(new SampleListener(userName));

            sender = ses.createProducer(dest);
            sender.setDeliveryMode(DeliveryMode.PERSISTENT);
            con.start();
            while (true) {
                String messageToSend = scanner.nextLine();
                if (messageToSend.trim().toLowerCase().equals("exit")) {
                    con.close();
                    System.exit(0);
                } else {
                    TextMessage sendMsg = ses.createTextMessage();
                    sendMsg.setText("[" + userName + "] :" + messageToSend);
                    sender.send(sendMsg);
                }
            }
        } catch (Exception exc) {
            exc.printStackTrace();
            System.exit(1);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (JMSException exc) {
                    System.err.println(exc);
                }
            }
        }
    }
}