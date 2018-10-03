import java.util.UUID;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;


public class MessagesAggregateTests {

  private FixtureConfiguration fixture;

  @Before
  public void setUp() throws Exception {
    fixture = Fixtures.newGivenWhenThenFixture(MessagesAggregate.class);
  }

  @Test
  public void testCreateMessageCommand(){
    String eventText = "Hello, how is your day?";
    String id = UUID.randomUUID().toString();
    fixture.given()
        .when(new CreateMessageCommand(id, eventText))
        .expectEvents(new MessageCreatedEvent(id, eventText));
  }

  @Test
  public void testMarkReadMessageCommand(){
    String id =  UUID.randomUUID().toString();

    fixture.given(new MessageCreatedEvent(id,"Hello"))
        .when(new MarkReadMessageCommand(id))
        .expectEvents(new MessageReadEvent(id));
  }
}
