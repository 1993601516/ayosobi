package cn.jiawei.blog.pojo;

import java.util.Date;

public class LoginUser {
    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String email;
    private Date login_time;
    private String avatarimg_url;

    public String getAvatarimg_url() {
        return avatarimg_url;
    }

    public void setAvatarimg_url(String avatarimg_url) {
        this.avatarimg_url = avatarimg_url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }


    public LoginUser() {
    }

    public LoginUser(Integer id, String username, String password, String realname, String email, Date login_time, String avatarimg_url) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.email = email;
        this.login_time = login_time;
        this.avatarimg_url = avatarimg_url;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", email='" + email + '\'' +
                ", login_time=" + login_time +
                ", avatarimg_url='" + avatarimg_url + '\'' +
                '}';
    }
}
