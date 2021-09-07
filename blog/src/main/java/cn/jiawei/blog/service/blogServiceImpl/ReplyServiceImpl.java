package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.blogDao.CommentMapper;
import cn.jiawei.blog.dao.blogDao.ReplyMapper;
import cn.jiawei.blog.pojo.Comment;
import cn.jiawei.blog.pojo.Reply;
import cn.jiawei.blog.service.blogService.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<List<Reply>> selectByReplyLists(List<Comment> comments) {
        List<List<Reply>> lists = new ArrayList<>();
        for (Comment comment : comments) {
            List<Reply> replies = replyMapper.selectByListReply(comment.getComment_id());
            lists.add(replies);
        }
        return lists;
    }

    @Override
    public int InsertReply(Reply reply,String replyname) {
        Comment comment = commentMapper.SelectByPrimaryKey(reply.getComment_id());
        if(comment.getComment_nickname().equals(replyname)){
            reply.setReply_body(reply.getReply_body().replace("@"+comment.getComment_nickname(),""));
        }
        reply.setReply_avatar("/css/img/avatar/common.jpg");
        reply.setReply_create(new Date());
      return replyMapper.InsertOneReply(reply);
    }
}
