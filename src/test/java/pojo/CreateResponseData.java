package pojo;

public class CreateResponseData {
    private String field;
    private String message;

    public CreateResponseData(){};
    public CreateResponseData(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
