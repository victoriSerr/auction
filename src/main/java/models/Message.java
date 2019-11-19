package models;

public class Message {
    private Long id;
    private Long fromUserId;
    private Long toUserId;
    private String message;

    public Message(Long id, Long fromUserId, Long toUserId, String message) {
        this.id = id;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.message = message;
    }

    public Message(Long fromUserId, Long toUserId, String message) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public Message setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public Message setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
        return this;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public Message setToUserId(Long toUserId) {
        this.toUserId = toUserId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }
}
