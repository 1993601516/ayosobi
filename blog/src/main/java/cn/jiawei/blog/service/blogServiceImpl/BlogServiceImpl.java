package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.adminDao.BlogMapper;
import cn.jiawei.blog.dao.adminDao.LoginMapper;
import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.LoginUser;
import cn.jiawei.blog.pojo.Pagination;
import cn.jiawei.blog.pojo.Tags;
import cn.jiawei.blog.pojo.vo.ArticleVO;
import cn.jiawei.blog.service.blogService.BlogService;
import cn.jiawei.blog.service.blogService.LoginUserService;
import cn.jiawei.blog.service.blogService.TagsService;
import cn.jiawei.blog.unitl.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    TagsService tagsService;
    @Autowired
    LoginMapper loginMapper;
    @Override
    @Transactional
    public String InsertInto(Blog blog) {
        Date date = new Date();
        /*给博客添加创建时间，状态和作者*/
        blog.setBlog_create(date);
        blog.setBlog_author(CurrentUser.CURRENT_REALNAM.getRealname());
        /*查询标签是否已存在*/
        String tagsId = TagsListByname(blog.getBlog_tag());
        blog.setBlog_tag_id(tagsId);
        if(blogMapper.InsertOne(blog)>0){
            return "成功";
        }
        return "失败";
    }
    /*查询tags*/
    public String TagsListByname(String tags){
        String[] split = tags.trim().split(",");
        String [] resultTagsId= new String[split.length];
        /*添加tags*/
        for(int i=0;i<split.length;i++){
            if(tagsService.selectOneByName(split[i])==null){
                Tags tag = new Tags();
                tag.setTag_create(new Date());
                tag.setTag_name(split[i]);
                tagsService.insertOneTag(tag);
            }
        }
        /*遍历split*/
        for(int i=0;i<split.length;i++){
            Tags tag = tagsService.selectOneByName(split[i]);
            resultTagsId[i]=String.valueOf(tag.getTag_id());
        }
        /*返回标签id字符串*/
       return StringUtils.join(resultTagsId, ",");
    }
    /*查询所有的博客*/
    @Override
    public List<Blog> SelectByAll() {
    /*筛选博客*/
        List<Blog> blogs = blogMapper.SelectByAll();
        /*使用工具类将其转换为text和已发布*/
        return toTextGentor.toText(blogs);
    }
    /*查询单个博客并修改状态*/
    @Override
    public Blog SelectByPrimarykey(int blog_id) {
        Blog blogVo = new Blog();
        Blog blog = blogMapper.SelectByPrimarykey(blog_id);
        blog.setBlog_update(new Date());
        blog.setBlog_view(blog.getBlog_view()+1);
        /*修改阅读量*/
        blogMapper.UpdateByprimaryKey(blog.getBlog_view(), blog.getBlog_id(),blog.getBlog_update());
        BeanUtils.copyProperties(blog, blogVo);
        /*转换md成html*/
        blogVo.setBlog_content(mdToHtml.mdToHtml(blogVo.getBlog_content()));
        return  blogVo;
    }
    /*通过博客作者查找头像*/
    @Override
    public String SelectByPrimaryKey(Blog blog) {
        LoginUser loginUser = loginMapper.queryByrealname(blog.getBlog_author());
        return loginUser.getAvatarimg_url();
    }

    @Override
    public ArticleVO Instantiation(List<Blog> blogs) {
        ArticleVO articleVO= new ArticleVO();
        List<String> blogTitles = new ArrayList<>();
        List<Integer> blogIds = new ArrayList<>();
        articleVO.setArticleCount(blogMapper.blogCount());
        for (Blog blog : blogs) {
            blogTitles.add(blog.getBlog_title());
            blogIds.add(blog.getBlog_id());
        }
        articleVO.setBlog_id(blogIds);
        articleVO.setBlog_title(blogTitles);
        return articleVO;
    }

    @Override
    public List<Blog> ListBlogByTag(String tag_name) {
        return toTextGentor.toText(blogMapper.selectListBlogByTagName(tag_name));
    }

    @Override
    public List<Blog> selctListBlogByCategoryId(int category_id) {
        List<Blog> blogs = blogMapper.selctListBlogByCategoryId(category_id);
        return blogs;
    }

    @Override
    /*status 状态码  1表示博客显示用  2表示管理用*/
    public List<Blog> BlogPages(int start, int pageCount,int staus) {
        /*通过计算拦截大于或者小于的页码*/
        int computedStart = 0;
        if(start<=0){
            computedStart=1;
        }
        int i = blogMapper.blogCount();
        /*如果总条数对每页记录数有余则总页数+1*/
        int totalpage = i/pageCount;
        if(i%pageCount>0){
            totalpage+=1;
        }
        if(start>totalpage){
            computedStart=totalpage;
        }
        if(start>=1 &&start<=totalpage){
            computedStart=start;
        }
        Page page = PaginationUntil.CurrentPageSet(computedStart, pageCount);
        List<Blog> blogs = blogMapper.selectBlogsLimit(page);
        /*返回一个全部都已发布的文章的list*/
        List<Blog> blogList = toTextGentor.toText(blogs);
        if(staus==1){
            return blogList;
        }else{
            return blogs;
        }
    }

    @Override
    public Pagination ComputedPagination(int current, int recodings) {
         Pagination pagination =new Pagination();
         pagination.setRecodings(recodings);
         /*查询博客总条数*/
        int i = blogMapper.blogCount();
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
    public int BlogUpdate(Blog blog) {
        TagsListByname(blog.getBlog_tag());
        return  blogMapper.BlogUpdateByPrimaryKey(blog);
    }

}
