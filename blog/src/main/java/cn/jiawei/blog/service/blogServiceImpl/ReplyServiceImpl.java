package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.blogDao.CommentMapper;
import cn.jiawei.blog.dao.blogDao.ReplyMapper;
import cn.jiawei.blog.pojo.Comment;
import cn.jiawei.blog.pojo.Pagination;
import cn.jiawei.blog.pojo.Reply;
import cn.jiawei.blog.service.blogService.ReplyService;
import cn.jiawei.blog.unitl.Page;
import cn.jiawei.blog.unitl.PaginationUntil;
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

    @Override
    public List<Reply> ReplyPage(int current, int pageCount,int comment_id) {
        int i = replyMapper.ReplyCount(comment_id);
        /*如果总条数对每页记录数有余则总页数+1*/
        int totalpage = i/pageCount;
        if(i%pageCount>0){
            ++totalpage;
        }
        if(current>=1&&current<=totalpage){
            return replyMapper.ReplyPage((current-1)*pageCount,pageCount,comment_id);
        }
         return replyMapper.ReplyPage(0, pageCount, comment_id);
    }

    @Override
    public Pagination ReplyComputed(int current, int recodings,int comment_id) {
        Pagination pagination =new Pagination();
        pagination.setRecodings(recodings);
        /*查询博客总条数*/
        int i = replyMapper.ReplyCount(comment_id);
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
    public int ReplyDeleteByReplyId(int reply_id) {
        return replyMapper.ReplyDeleteByReplyId(reply_id);
    }
}
