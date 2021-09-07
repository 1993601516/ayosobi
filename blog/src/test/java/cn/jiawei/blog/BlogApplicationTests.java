package cn.jiawei.blog;

import cn.jiawei.blog.dao.adminDao.BlogMapper;
import cn.jiawei.blog.dao.blogDao.CommentMapper;
import cn.jiawei.blog.dao.blogDao.ReplyMapper;
import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.Comment;
import cn.jiawei.blog.pojo.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    ReplyMapper replyMapper;
    @Test
    void contextLoads() throws UnsupportedEncodingException {
        Reply reply = new Reply();
        reply.setComment_id(1);
        reply.setReply_body("真好");
        reply.setReply_create(new Date());
        reply.setReply_nickname("刘华强");
        reply.setReply_avatar("/css/img/avatar/avatar.jpg");
        replyMapper.InsertOneReply(reply);
    }

}
