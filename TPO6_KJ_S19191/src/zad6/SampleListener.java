package zad6;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SampleListener implements MessageListener {
    String userName;

    public SampleListener(String userName) {
        this.userName = userName;
    }

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage text = (TextMessage) message;
            try {
                if (!text.getText().contains(userName))
                System.out.println("Received from: " + text.getText());
            } catch (JMSException exception) {
                System.err.println("Failed to get message text: " + exception);
            }
        }
    }
}