package pojo;

public class DeleteResponseRoot {
    private Integer code;
    private Object meta;
    private DeleteResponseData data;

    public DeleteResponseRoot(){};

    public DeleteResponseRoot(Integer code, Object meta, DeleteResponseData data) {
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

    public DeleteResponseData getData() {
        return data;
    }
}

