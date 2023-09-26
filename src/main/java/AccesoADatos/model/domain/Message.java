package AccesoADatos.model.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "Message")
public class Message implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	
	private User sender;
    private String content;
    private LocalDateTime timestamp;

    public Message() {
    }

    public Message(User sender, String content, LocalDateTime timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }
    @XmlElement (name = "Sender")
    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
 @XmlElement (name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
  @XmlElement (name = "Timestamp")
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
