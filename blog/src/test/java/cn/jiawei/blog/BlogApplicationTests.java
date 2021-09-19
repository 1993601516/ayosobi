package cn.jiawei.blog;

import cn.jiawei.blog.dao.adminDao.BlogMapper;
import cn.jiawei.blog.dao.blogDao.CommentMapper;
import cn.jiawei.blog.dao.blogDao.ReplyMapper;
import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.Comment;
import cn.jiawei.blog.pojo.Reply;
import cn.jiawei.blog.unitl.Page;
import cn.jiawei.blog.unitl.PaginationUntil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    BlogMapper blogMapper;
    @Test
    void contextLoads() throws UnsupportedEncodingException {
}

}
