import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public class MessagesAggregate extends AbstractAnnotatedAggregateRoot {

  public MessagesAggregate() {
  }

  @AggregateIdentifier
  private String id;

  public MessagesAggregate(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @CommandHandler
  public MessagesAggregate(CreateMessageCommand command) {
    apply(new MessageCreatedEvent(command.getId(), command.getText()));
  }

  @EventHandler
  public void on(MessageCreatedEvent event) {
    this.id = event.getId();
  }

  @CommandHandler
  public void markRead(MarkReadMessageCommand command) {
    apply(new MessageReadEvent(id));
  }
}
