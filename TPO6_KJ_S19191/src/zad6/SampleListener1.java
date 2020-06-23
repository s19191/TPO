package zad6;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

// SampleListener1 wyświetla wiadomości tylko od innych urzytkowników (nie ten co ją wysłał)

public class SampleListener1 implements MessageListener {
    String name;

    public SampleListener1(String name) {
        this.name = name;
    }

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage text = (TextMessage) message;
            try {
                if (!text.getText().contains(name))
                System.out.println("Received from: " + text.getText());
            } catch (JMSException exception) {
                System.err.println("Failed to get message text: " + exception);
            }
        }
    }
}