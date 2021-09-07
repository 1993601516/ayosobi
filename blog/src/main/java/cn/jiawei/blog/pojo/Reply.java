package cn.jiawei.blog.pojo;

import java.util.Date;

public class Reply {
    private int reply_id;
    private int comment_id;
    private Date reply_create;
    private String reply_body;
    private String reply_avatar;
    private String reply_nickname;
    private String reply_email;
    public Reply() {
    }

    public Reply(int reply_id, int comment_id, Date reply_create, String reply_body, String reply_avatar, String reply_nickname,String reply_email) {
        this.reply_id = reply_id;
        this.comment_id = comment_id;
        this.reply_create = reply_create;
        this.reply_body = reply_body;
        this.reply_avatar = reply_avatar;
        this.reply_nickname = reply_nickname;
        this.reply_email = reply_email;
    }

    public String getReply_email() {
        return reply_email;
    }

    public void setReply_email(String reply_email) {
        this.reply_email = reply_email;
    }

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public Date getReply_create() {
        return reply_create;
    }

    public void setReply_create(Date reply_create) {
        this.reply_create = reply_create;
    }

    public String getReply_body() {
        return reply_body;
    }

    public void setReply_body(String reply_body) {
        this.reply_body = reply_body;
    }

    public String getReply_avatar() {
        return reply_avatar;
    }

    public void setReply_avatar(String reply_avatar) {
        this.reply_avatar = reply_avatar;
    }

    public String getReply_nickname() {
        return reply_nickname;
    }

    public void setReply_nickname(String reply_nickname) {
        this.reply_nickname = reply_nickname;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "reply_id=" + reply_id +
                ", comment_id=" + comment_id +
                ", reply_create=" + reply_create +
                ", reply_body='" + reply_body + '\'' +
                ", reply_avatar='" + reply_avatar + '\'' +
                ", reply_nickname='" + reply_nickname + '\'' +
                ", reply_email='" + reply_email + '\'' +
                '}';
    }
}
