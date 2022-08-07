package pojo;

import java.util.ArrayList;

public class CreateResponseRoot {
    private Integer code;
    private Object meta;
    private ArrayList<CreateResponseData> data;

    public CreateResponseRoot(){};

    public CreateResponseRoot(Integer code, Object meta, ArrayList<CreateResponseData> data) {
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

    public ArrayList<CreateResponseData> getData() {
        return data;
    }
}
