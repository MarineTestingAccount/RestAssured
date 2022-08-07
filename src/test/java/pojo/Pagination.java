package pojo;

public class Pagination {
    private Integer total;
    private Integer pages;
    private Integer page;
    private Integer limit;


    public Pagination(){};
    public Pagination(Integer total, Integer pages, Integer page, Integer limit) {
        this.total = total;
        this.pages = pages;
        this.page = page;
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getPages() {
        return pages;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getLimit() {
        return limit;
    }
}
