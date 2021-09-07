package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.blogDao.CommentMapper;
import cn.jiawei.blog.pojo.Comment;
import cn.jiawei.blog.service.blogService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Comment> SelectByCommentList(int blog_id) {
     return commentMapper.SelectByListComment(blog_id);
    }

    @Override
    public int InsertOneComment(Comment comment) {
        if(comment.getComment_avatar()==null){
            comment.setComment_avatar("/css/img/avatar/common.jpg");
        }
        comment.setCreatetime(new Date());
        return commentMapper.InsertOneComment(comment);
    }

}
