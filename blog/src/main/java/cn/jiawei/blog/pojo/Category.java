package cn.jiawei.blog.pojo;

import java.util.Date;

public class Category {
    private int category_id;
    private String category_name;
    private int category_sort;
    private Date category_create;

    public Date getCategory_create() {
        return category_create;
    }

    public void setCategory_create(Date category_create) {
        this.category_create = category_create;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getCategory_sort() {
        return category_sort;
    }

    public void setCategory_sort(int category_sort) {
        this.category_sort = category_sort;
    }

    public Category() {
    }

    public Category(int category_id, String category_name, int category_sort, Date category_create) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_sort = category_sort;
        this.category_create = category_create;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", category_sort=" + category_sort +
                ", category_create=" + category_create +
                '}';
    }
}
