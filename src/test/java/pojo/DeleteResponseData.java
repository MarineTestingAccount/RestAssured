package pojo;

public class DeleteResponseData {
    private String message;

    public DeleteResponseData(){};
    public DeleteResponseData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
