package cn.jiawei.blog.pojo;

public class Pagination {
    private  int current;
    private  int recodings;
    private  int total;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRecodings() {
        return recodings;
    }

    public void setRecodings(int recodings) {
        this.recodings = recodings;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Pagination() {
    }

    public Pagination(int current, int recodings, int total) {
        this.current = current;
        this.recodings = recodings;
        this.total = total;
    }
}
