package cn.jiawei.blog.dao.blogDao;

import cn.jiawei.blog.pojo.Reply;
import cn.jiawei.blog.unitl.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReplyMapper {
    List<Reply> selectByListReply(int comment_id);
    int InsertOneReply(Reply reply);
    List<Reply> ReplyPage(int start,int pagecount,int comment_id);
    int ReplyCount(int comment_id);
    int ReplyDelete(int comment_id);
    int ReplyDeleteByReplyId(int reply_id);
}
