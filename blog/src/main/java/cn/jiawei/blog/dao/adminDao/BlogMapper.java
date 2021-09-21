package cn.jiawei.blog.dao.adminDao;

import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.unitl.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface BlogMapper {
    int InsertOne(Blog blog);
    Blog SelectByPrimarykey(int blog_id);
    List<Blog> SelectByAll();
    int UpdateByprimaryKey(int blog_view, int blog_id,Date blog_update);
    int blogCount();
    /*标签名查询*/
    List<Blog> selectListBlogByTagName(String tag_name);
    List<Blog> selctListBlogByCategoryId(int category_id);
    /*分页查询*/
    List<Blog> selectBlogsLimit(Page page);
    int BlogUpdateByPrimaryKey(Blog blog);
    int BlogDeleteByPrimaryKey(int blog_id);
}
