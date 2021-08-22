package cn.jiawei.blog.controller.admin;

import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.Category;
import cn.jiawei.blog.service.blogService.BlogService;
import cn.jiawei.blog.service.blogService.CategoryService;
import cn.jiawei.blog.unitl.Result;
import cn.jiawei.blog.unitl.ResultGentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

@Controller
@RequestMapping("/admin")
public class ArticleController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;
    @RequestMapping("/article")
    public String article(){
        return "admin/article";
    }
    /*添加博客*/
    @ResponseBody
    @PostMapping("/saveBlog")
    public Result saveblog(@RequestParam("blog_title") String blog_title,
                           @RequestParam("blog_tag")String blog_tag,
                           @RequestParam("blog_category")String blog_category,
                           @RequestParam("blog_content")String blog_content,
                           @RequestParam("blog_url")String blog_url,
                           @RequestParam("blog_coverImg") String blog_coverImg){
        if(StringUtils.isEmpty(blog_title)){
          return ResultGentor.setFAIL_RESULT("请输入文章标题");
        }
        if(blog_title.trim().length()>100){
            return ResultGentor.setFAIL_RESULT("标题太长了");
        }
        if(StringUtils.isEmpty(blog_tag)){
            return ResultGentor.setFAIL_RESULT("请输入标签");
        }
        if(blog_tag.trim().length()>10){
            return ResultGentor.setFAIL_RESULT("标签不能大于十个字");
        }
        if(StringUtils.isEmpty(blog_category)){
            return ResultGentor.setFAIL_RESULT("请选择分类");
        }
        if(blog_category.trim().length()>10){
            return ResultGentor.setFAIL_RESULT("分类名太长了啊喂");
        }
        if(StringUtils.isEmpty(blog_content)){
            return ResultGentor.setFAIL_RESULT("西方不能失去耶路撒冷，博客页不能没有内容");
        }
        if(blog_content.trim().length()>10000){
            return ResultGentor.setFAIL_RESULT("正文长度不能超过10000字");
        }
        if(StringUtils.isEmpty(blog_url)){
            return ResultGentor.setFAIL_RESULT("图片地址不能为空");
        }
        Blog blog = new Blog();
        Category category = categoryService.selectOneByname(blog_category);
        if(category==null){
            /*如果差不多就默认为0*/
            blog.setBlog_category_id(0);
        }else{
            blog.setBlog_category_id(category.getCategory_id());
        }
        blog.setBlog_coverImg(blog_coverImg);
        blog.setBlog_tag(blog_tag);
        blog.setBlog_title(blog_title);
        blog.setBlog_img(blog_url);
        blog.setBlog_content(blog_content);
        String result = blogService.InsertInto(blog);
        if(result.equals("成功")){
            return  ResultGentor.setSUCCESS_RESULT();
        }
        return ResultGentor.setERROR_RESULT(404, "失败");
    }

    @PostMapping("/updateBlog")
    @ResponseBody
    public Result update(@RequestParam("blog_title") String blog_title,
                         @RequestParam("blog_tag")String blog_tag,
                         @RequestParam("blog_category")String blog_category,
                         @RequestParam("blog_content")String blog_content,
                         @RequestParam("blog_url")String blog_url,
                         @RequestParam("blog_coverImg") String blog_coverImg){
        return null;
    }

}
