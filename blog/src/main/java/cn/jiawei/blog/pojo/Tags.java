package cn.jiawei.blog.pojo;

import java.util.Date;

public class Tags {
    private int tag_id;
    private String tag_name;
    private int tag_sort;
    private Date tag_create;
    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public int getTag_sort() {
        return tag_sort;
    }

    public void setTag_sort(int tag_sort) {
        this.tag_sort = tag_sort;
    }

    public Date getTag_create() {
        return tag_create;
    }

    public void setTag_create(Date tag_create) {
        this.tag_create = tag_create;
    }

    public Tags(int tag_id, String tag_name, int tag_sort, Date tag_create) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
        this.tag_sort = tag_sort;
        this.tag_create = tag_create;
    }

    public Tags() {
    }

    @Override
    public String toString() {
        return "Tags{" +
                "tag_id=" + tag_id +
                ", tag_name='" + tag_name + '\'' +
                ", tag_sort=" + tag_sort +
                ", tag_create=" + tag_create +
                '}';
    }
}
