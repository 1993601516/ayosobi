package cn.jiawei.blog.dao.blogDao;

import cn.jiawei.blog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {
    int InsertOneComment(Comment comment);
    List<Comment> SelectByListComment(int blog_id);
    Comment SelectByPrimaryKey(int comment_id);
}
