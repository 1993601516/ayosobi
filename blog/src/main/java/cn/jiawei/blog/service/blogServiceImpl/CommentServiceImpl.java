package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.blogDao.CommentMapper;
import cn.jiawei.blog.dao.blogDao.ReplyMapper;
import cn.jiawei.blog.pojo.Comment;
import cn.jiawei.blog.pojo.Pagination;
import cn.jiawei.blog.service.blogService.CommentService;
import cn.jiawei.blog.unitl.Page;
import cn.jiawei.blog.unitl.PaginationUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    ReplyMapper replyMapper;
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

    @Override
    public List<Comment> CommentPage(int current, int pageCount) {
        Page page = PaginationUntil.CurrentPageSet(current, pageCount);
        return commentMapper.CommentsPage(page);
    }

    @Override
    public Pagination CommentComputed(int current, int recodings) {
        Pagination pagination =new Pagination();
        pagination.setRecodings(recodings);
        /*查询博客总条数*/
        int i = commentMapper.CommentCount();
        /*如果总条数对每页记录数有余则总页数+1*/
        int totalpage = i/recodings;
        if(i%recodings>0){
            ++totalpage;
        }
        /*判断是否在页数之间*/
        if(current<=totalpage && current>=1){
            pagination.setCurrent(current);
        }else if(current<=0){
            /*判断是否小于首页*/
            pagination.setCurrent(1);
        }else if(current>totalpage){
            /*判断是否大于尾页*/
            pagination.setCurrent(totalpage);
        }
        pagination.setTotal(totalpage);
        return pagination;
    }

    @Override
    public int CommentDelete(int comment_id) {
        /*删除主评论和子评论*/
        int i = commentMapper.CommentDelete(comment_id);
        int i1 = replyMapper.ReplyDelete(comment_id);
        return i+i1;
    }

}
