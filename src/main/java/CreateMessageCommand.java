import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CreateMessageCommand {

  @TargetAggregateIdentifier
  private String id;
  private String text;

  public CreateMessageCommand(String id, String text) {
    this.id = id;
    this.text = text;
  }

  // ...
}
