package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.adminDao.BlogMapper;
import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.Tags;
import cn.jiawei.blog.service.blogService.BlogService;
import cn.jiawei.blog.service.blogService.TagsService;
import cn.jiawei.blog.unitl.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    TagsService tagsService;
    @Override
    @Transactional
    public String InsertInto(Blog blog) {
        Date date = new Date();
        /*给博客添加创建时间，状态和作者*/
        blog.setBlog_create(date);
        blog.setBlog_author(CurrentUser.CURRENT_REALNAM.getRealname());
        blog.setBlog_status(1);
        /*查询标签是否已存在*/
        if(tagsService.selectOneByName(blog.getBlog_tag())==null){
            /*不存在就添加*/
            Tags tags = new Tags();
            tags.setTag_create(new Date());
            tags.setTag_name(blog.getBlog_tag());
            Integer result = tagsService.insertOneTag(tags);
        }else{
            /*标签已经存在*/
            Tags tags = tagsService.selectOneByName(blog.getBlog_tag());
            blog.setBlog_tag_id(tags.getTag_id());
        }
        if(blogMapper.InsertOne(blog)>0){
            return "成功";
        }
        return "失败";
    }
    /*查询所有的博客*/
    @Override
    public List<Blog> SelectByAll() {
     return blogMapper.SelectByAll();
    }

    @Override
    public Blog SelectByPrimarykey(String blog_id) {
      return blogMapper.SelectByPrimarykey(Integer.parseInt(blog_id));
    }
}
