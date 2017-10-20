package hello;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(100);

    @Autowired
    MessageRepository messageRepository;

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        try{
            messageRepository.save(new Message(message));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Saved in Database : ");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}