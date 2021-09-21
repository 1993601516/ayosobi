package cn.jiawei.blog.service.blogService;

import cn.jiawei.blog.pojo.Comment;
import cn.jiawei.blog.pojo.Pagination;
import cn.jiawei.blog.unitl.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    public List<Comment> SelectByCommentList(int blog_id);
    public int InsertOneComment(Comment comment);
    public List<Comment> CommentPage(int current,int pageCount);
    public Pagination CommentComputed(int current,int recodings);
    int CommentDelete(int comment_id);
}
