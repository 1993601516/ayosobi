package cn.jiawei.blog;

import cn.jiawei.blog.dao.adminDao.BlogMapper;
import cn.jiawei.blog.pojo.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    BlogMapper blogMapper;
    @Test
    void contextLoads() throws UnsupportedEncodingException {
        Blog blog = new Blog();
        blog.setBlog_status(1);
        blog.setBlog_author("伍佳伟");
        blog.setBlog_create(new Date());
        blog.setBlog_tag("生活");
        blogMapper.InsertOne(blog);
    }

}
