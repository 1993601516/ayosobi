package cn.jiawei.blog.service.blogService;

import cn.jiawei.blog.pojo.Comment;
import cn.jiawei.blog.pojo.Reply;

import java.util.List;

public interface ReplyService {
    List<List<Reply>> selectByReplyLists(List<Comment> comments);
    int InsertReply(Reply reply,String replyname);
}
