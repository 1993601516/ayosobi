package cn.jiawei.blog.pojo;

import java.util.Date;

public class Blog {
    private int blog_id;
    private int blog_tag_id;
    private int blog_category_id;
    private int blog_view;
    private int blog_status;
    private String blog_title;
    private String blog_content;
    private String blog_img;
    private String blog_author;
    private Date blog_create;
    private Date blog_update;
    private String blog_tag;
    private String blog_coverImg;

    public String getBlog_coverImg() {
        return blog_coverImg;
    }

    public void setBlog_coverImg(String blog_coverImg) {
        this.blog_coverImg = blog_coverImg;
    }

    public String getBlog_tag() {
        return blog_tag;
    }

    public void setBlog_tag(String blog_tag) {
        this.blog_tag = blog_tag;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public int getBlog_tag_id() {
        return blog_tag_id;
    }

    public void setBlog_tag_id(int blog_tag_id) {
        this.blog_tag_id = blog_tag_id;
    }

    public int getBlog_category_id() {
        return blog_category_id;
    }

    public void setBlog_category_id(int blog_category_id) {
        this.blog_category_id = blog_category_id;
    }

    public int getBlog_view() {
        return blog_view;
    }

    public void setBlog_view(int blog_view) {
        this.blog_view = blog_view;
    }

    public int getBlog_status() {
        return blog_status;
    }

    public void setBlog_status(int blog_status) {
        this.blog_status = blog_status;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title;
    }

    public String getBlog_content() {
        return blog_content;
    }

    public void setBlog_content(String blog_content) {
        this.blog_content = blog_content;
    }

    public String getBlog_img() {
        return blog_img;
    }

    public void setBlog_img(String blog_img) {
        this.blog_img = blog_img;
    }

    public String getBlog_author() {
        return blog_author;
    }

    public void setBlog_author(String blog_author) {
        this.blog_author = blog_author;
    }

    public Date getBlog_create() {
        return blog_create;
    }

    public void setBlog_create(Date blog_create) {
        this.blog_create = blog_create;
    }

    public Date getBlog_update() {
        return blog_update;
    }

    public void setBlog_update(Date blog_update) {
        this.blog_update = blog_update;
    }

    public Blog() {
    }

    public Blog(int blog_id, int blog_tag_id, int blog_category_id, int blog_view, int blog_status, String blog_title, String blog_content, String blog_img, String blog_author, Date blog_create, Date blog_update, String blog_tag,String blog_coverImg) {
        this.blog_id = blog_id;
        this.blog_tag_id = blog_tag_id;
        this.blog_category_id = blog_category_id;
        this.blog_view = blog_view;
        this.blog_status = blog_status;
        this.blog_title = blog_title;
        this.blog_content = blog_content;
        this.blog_img = blog_img;
        this.blog_author = blog_author;
        this.blog_create = blog_create;
        this.blog_update = blog_update;
        this.blog_tag = blog_tag;
        this.blog_coverImg=blog_coverImg;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blog_id=" + blog_id +
                ", blog_tag_id=" + blog_tag_id +
                ", blog_category_id=" + blog_category_id +
                ", blog_view=" + blog_view +
                ", blog_status=" + blog_status +
                ", blog_title='" + blog_title + '\'' +
                ", blog_content='" + blog_content + '\'' +
                ", blog_img='" + blog_img + '\'' +
                ", blog_author='" + blog_author + '\'' +
                ", blog_create=" + blog_create +
                ", blog_update=" + blog_update +
                ", blog_tag='" + blog_tag + '\'' +
                ", blog_coverImg='" + blog_coverImg + '\'' +
                '}';
    }
}
