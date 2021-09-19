package cn.jiawei.blog.service.blogService;

import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.Pagination;
import cn.jiawei.blog.pojo.vo.ArticleVO;

import java.util.List;

public interface BlogService {
    String InsertInto(Blog blog);
    List<Blog> SelectByAll();
    Blog SelectByPrimarykey(int blog_id);
    String SelectByPrimaryKey(Blog blog);
    ArticleVO Instantiation(List<Blog> blogs);
    List<Blog> ListBlogByTag(String tag_name);
    List<Blog> selctListBlogByCategoryId(int category_id);
    List<Blog> BlogPages(int start,int pageCount,int status);
    Pagination ComputedPagination(int current,int recodings);
    int BlogUpdate(Blog blog);
}
