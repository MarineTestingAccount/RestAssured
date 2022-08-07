package pojo;

public class ResponseData {
    private String message;

    public ResponseData(){};
    public ResponseData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
