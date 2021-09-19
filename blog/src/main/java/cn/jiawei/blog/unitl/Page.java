package cn.jiawei.blog.unitl;

public class Page {
    private int start=PaginationUntil.Current;
    private int pagecount=PaginationUntil.pageCount;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }
}
