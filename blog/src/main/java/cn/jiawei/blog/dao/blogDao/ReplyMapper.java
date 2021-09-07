package cn.jiawei.blog.dao.blogDao;

import cn.jiawei.blog.pojo.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReplyMapper {
    List<Reply> selectByListReply(int comment_id);
    int InsertOneReply(Reply reply);
}
