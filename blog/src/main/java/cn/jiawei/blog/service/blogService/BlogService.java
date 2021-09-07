package cn.jiawei.blog.service.blogService;

import cn.jiawei.blog.pojo.Blog;

import java.util.List;

public interface BlogService {
    String InsertInto(Blog blog);
    List<Blog> SelectByAll();
    Blog SelectByPrimarykey(String blog_id);
    String SelectByPrimaryKey(Blog blog);
}
