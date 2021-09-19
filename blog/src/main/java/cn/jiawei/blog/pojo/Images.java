package cn.jiawei.blog.pojo;

public class Images {
    private int img_id;
    private String img_url;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getId() {
        return img_id;
    }

    public void setId(int img_id) {
        this.img_id = img_id;
    }

    public Images(int img_id, String img_url) {
        this.img_id = img_id;
        this.img_url = img_url;
    }

    public Images() {
    }
}
