package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.List;

public class Root {
    private Integer code;
    private Meta meta;
    private List<Data> data;

    public Root(){};
    public Root(Integer code, Meta meta, ArrayList<Data> data) {
        this.code = code;
        this.meta = meta;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public Meta getMeta() {
        return meta;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public void setData(List<Data> data)
    {

        this.data = data;
    }

    @Override
    public String toString()
    {
        return "rootPojo [code =" + code+", meta=" + meta + ", data=" + data + "]";
    }
}

