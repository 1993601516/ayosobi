package cn.jiawei.blog.unitl;

public class PaginationUntil {
    public static final   int Current=0;
    public static final   int pageCount=5;

    public static Page CurrentPageSet(int current,int pageCount){
        Page page = new Page();
        page.setStart((current-1)*pageCount);
        page.setPagecount(pageCount);
        return page;
    }
}
