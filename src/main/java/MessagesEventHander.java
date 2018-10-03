import org.axonframework.eventhandling.annotation.EventHandler;

public class MessagesEventHander {

  @EventHandler
  public void handle(MessageCreatedEvent event) {
    System.out.println("Message received: " + event.getText() + " ("
        + event.getId() + ")");
  }

  @EventHandler
  public void handle(MessageReadEvent event) {
    System.out.println("Message read: " + event.getId());
  }
}
