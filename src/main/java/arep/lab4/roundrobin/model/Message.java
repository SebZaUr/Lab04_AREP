package arep.lab4.roundrobin.model;


import arep.lab4.roundrobin.service.MessageService;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("message")
public class Message {
    @Id
    private Integer Id;
    private String message;

    public Message() {
    }

    public Message(Integer id, String message) {
        Id = id;
        this.message = message;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
