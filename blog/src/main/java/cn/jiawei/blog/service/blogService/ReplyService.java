package cn.jiawei.blog.service.blogService;

import cn.jiawei.blog.pojo.Comment;
import cn.jiawei.blog.pojo.Pagination;
import cn.jiawei.blog.pojo.Reply;

import java.util.List;

public interface ReplyService {
    List<List<Reply>> selectByReplyLists(List<Comment> comments);
    int InsertReply(Reply reply,String replyname);
    List<Reply> ReplyPage(int current,int pageCount,int comment_id);
    Pagination ReplyComputed(int current,int recodings,int comment_id);
    int ReplyDeleteByReplyId( int reply_id);
}
