package pojo;

public class Meta {
    private Pagination pagination;

    public Meta(){};
    public Meta(Pagination pagination) {
        this.pagination = pagination;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
