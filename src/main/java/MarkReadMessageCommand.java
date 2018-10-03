import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class MarkReadMessageCommand {
  @TargetAggregateIdentifier
  private String id;

  public MarkReadMessageCommand(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
