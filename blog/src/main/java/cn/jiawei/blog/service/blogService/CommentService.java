package cn.jiawei.blog.service.blogService;

import cn.jiawei.blog.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    public List<Comment> SelectByCommentList(int blog_id);

    public int InsertOneComment(Comment comment);
}
