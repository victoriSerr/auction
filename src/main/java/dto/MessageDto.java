package dto;

public class MessageDto {
    private String fromUserLogin;
    private String toUserLogin;
    private String message;

    public MessageDto(String fromUserLogin, String toUserLogin, String message) {
        this.fromUserLogin = fromUserLogin;
        this.toUserLogin = toUserLogin;
        this.message = message;
    }

    public String getFromUserLogin() {
        return fromUserLogin;
    }

    public MessageDto setFromUserLogin(String fromUserLogin) {
        this.fromUserLogin = fromUserLogin;
        return this;
    }

    public String getToUserLogin() {
        return toUserLogin;
    }

    public MessageDto setToUserLogin(String toUserLogin) {
        this.toUserLogin = toUserLogin;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MessageDto setMessage(String message) {
        this.message = message;
        return this;
    }
}
