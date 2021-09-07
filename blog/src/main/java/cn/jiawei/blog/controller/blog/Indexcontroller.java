package cn.jiawei.blog.controller.blog;

import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.Comment;
import cn.jiawei.blog.pojo.LoginUser;
import cn.jiawei.blog.pojo.Reply;
import cn.jiawei.blog.service.blogService.BlogService;
import cn.jiawei.blog.service.blogService.CommentService;
import cn.jiawei.blog.service.blogService.LoginUserService;
import cn.jiawei.blog.service.blogService.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Indexcontroller {
    @Autowired
    BlogService blogService;
    @Autowired
    LoginUserService loginUserService;
    @Autowired
    CommentService commentService;
    @Autowired
    ReplyService replyService;
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
        List<Comment> comments = commentService.SelectByCommentList(Integer.parseInt(blog_id));
        List<List<Reply>> replyLists = replyService.selectByReplyLists(comments);
        String author_avatar = blogService.SelectByPrimaryKey(blog);
        model.addAttribute("blog", blog);
        model.addAttribute("comments", comments);
        model.addAttribute("replyLists", replyLists);
        model.addAttribute("avatar",author_avatar);
        return "/blogs";
    }
}
