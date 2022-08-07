package pojo;

public class ResponseRoot {
    private Integer code;
    private Object meta;
    private ResponseData data;

    public ResponseRoot(){};

    public ResponseRoot(Integer code, Object meta, ResponseData data) {
        this.code = code;
        this.meta = meta;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public Object getMeta() {
        return meta;
    }

    public ResponseData getData() {
        return data;
    }
}

