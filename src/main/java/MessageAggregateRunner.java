import java.io.File;
import java.util.UUID;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventhandling.annotation.AnnotationEventListenerAdapter;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.fs.FileSystemEventStore;
import org.axonframework.eventstore.fs.SimpleEventFileResolver;

public class MessageAggregateRunner {
  public static void main(String[] args) {
    // Let's start with a command Bus
    CommandBus commandBus = new SimpleCommandBus();

    // The CommandGateway provides a friendlier API
    CommandGateway commandGateway = new DefaultCommandGateway(commandBus);

    // we'll store the events in the filesystem
    EventStore eventStore = new FileSystemEventStore(new SimpleEventFileResolver(new File("./events")));

    // simple Event Bus
    EventBus eventBus = new SimpleEventBus();

    EventSourcingRepository repository = new EventSourcingRepository(MessagesAggregate.class, eventStore);
    repository.setEventBus(eventBus);

    AggregateAnnotationCommandHandler.subscribe(MessagesAggregate.class, repository, commandBus);
    AnnotationEventListenerAdapter.subscribe(new MessagesEventHander(), eventBus);

    String itemId = UUID.randomUUID().toString();
    commandGateway.send(new CreateMessageCommand(itemId, "Hello, how is your day?"));
    commandGateway.send(new MarkReadMessageCommand(itemId));
  }
}
