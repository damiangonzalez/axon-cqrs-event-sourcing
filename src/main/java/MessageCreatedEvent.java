public class MessageCreatedEvent {

  private String id;
  private String text;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public MessageCreatedEvent(String id, String text) {
    this.id = id;
    this.text = text;
  }
}
