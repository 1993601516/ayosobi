package cn.jiawei.blog.dao.adminDao;

import cn.jiawei.blog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {
    int InsertOne(Blog blog);
    Blog SelectByPrimarykey(int blog_id);
    List<Blog> SelectByAll();
    int UpdateByprimaryKey(int blog_view,int blog_id);
}
