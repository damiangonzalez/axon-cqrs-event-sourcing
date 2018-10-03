import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class MarkReadMessageCommand {
  @TargetAggregateIdentifier
  private String id;

  public MarkReadMessageCommand(String id) {
    this.id = id;
  }

  // ...
}
