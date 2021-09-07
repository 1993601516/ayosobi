package cn.jiawei.blog.pojo;

import java.util.Date;

public class Comment {
    private int comment_id;
    private int blog_id;
    private String comment_body;
    private Date createtime;
    private String comment_nickname;
    private String comment_email;
    private String comment_avatar;

    public Comment(int comment_id, int blog_id, String comment_body, Date createtime, String comment_nickname, String comment_email, String comment_avatar) {
        this.comment_id = comment_id;
        this.blog_id = blog_id;
        this.comment_body = comment_body;
        this.createtime = createtime;
        this.comment_nickname = comment_nickname;
        this.comment_email = comment_email;
        this.comment_avatar = comment_avatar;
    }

    public Comment() {
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getComment_body() {
        return comment_body;
    }

    public void setComment_body(String comment_body) {
        this.comment_body = comment_body;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getComment_nickname() {
        return comment_nickname;
    }

    public void setComment_nickname(String comment_nickname) {
        this.comment_nickname = comment_nickname;
    }

    public String getComment_email() {
        return comment_email;
    }

    public void setComment_email(String comment_email) {
        this.comment_email = comment_email;
    }

    public String getComment_avatar() {
        return comment_avatar;
    }

    public void setComment_avatar(String comment_avatar) {
        this.comment_avatar = comment_avatar;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", blog_id=" + blog_id +
                ", comment_body='" + comment_body + '\'' +
                ", createtime=" + createtime +
                ", comment_nickname='" + comment_nickname + '\'' +
                ", comment_email='" + comment_email + '\'' +
                ", comment_avatar='" + comment_avatar + '\'' +
                '}';
    }
}
