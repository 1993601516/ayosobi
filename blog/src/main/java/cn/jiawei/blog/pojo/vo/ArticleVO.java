package cn.jiawei.blog.pojo.vo;

import java.util.List;

public class ArticleVO {
    private int ArticleCount;
    private List<String> Blog_title;
    private List<Integer> Blog_id;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<String> getBlog_title() {
        return Blog_title;
    }

    public void setBlog_title(List<String> blog_title) {
        Blog_title = blog_title;
    }

    public List<Integer> getBlog_id() {
        return Blog_id;
    }

    public void setBlog_id(List<Integer> blog_id) {
        Blog_id = blog_id;
    }

    public ArticleVO() {
    }

    public ArticleVO(int articleCount, List<String> blog_title, List<Integer> blog_id) {
        ArticleCount = articleCount;
        Blog_title = blog_title;
        Blog_id = blog_id;
    }
}
