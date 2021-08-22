package cn.jiawei.blog.controller.blog;

import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.LoginUser;
import cn.jiawei.blog.service.blogService.BlogService;
import cn.jiawei.blog.service.blogService.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Indexcontroller {
    @Autowired
    BlogService blogService;
    @Autowired
    LoginUserService loginUserService;
    @RequestMapping("/")
    public String index(Model model){
        List<Blog> blogs = blogService.SelectByAll();
        List<String> avatars = loginUserService.queryByrealname(blogs);
        model.addAttribute("avatars", avatars);
        model.addAttribute("blogs", blogs);
        return "/index";
    }

    /*博客具体内容*/
    @GetMapping("/blog/{blog_id}")
    public String blog(Model model,
                       @PathVariable String blog_id){
        Blog blog = blogService.SelectByPrimarykey(blog_id);
        model.addAttribute("blog", blog);
        return "/blogs";
    }
}
