package cn.jiawei.blog.controller.admin;

import cn.jiawei.blog.pojo.Comment;
import cn.jiawei.blog.pojo.Pagination;
import cn.jiawei.blog.service.blogService.CommentService;
import cn.jiawei.blog.unitl.Result;
import cn.jiawei.blog.unitl.ResultGentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping("/admin/comment")
    public String comment(Model model){
        List<Comment> comments = commentService.CommentPage(1, 8);
        Pagination pagination = commentService.CommentComputed(1, 8);
        model.addAttribute("pagination", pagination);
        model.addAttribute("comments", comments);
        return "/admin/comment";
    }

    @GetMapping("/admin/comment/{current}/{pageCount}")
    public String comment(Model model,
                          @PathVariable int current,
                          @PathVariable int pageCount){
        List<Comment> comments = commentService.CommentPage(current, pageCount);
        Pagination pagination = commentService.CommentComputed(current, pageCount);
        model.addAttribute("pagination", pagination);
        model.addAttribute("comments", comments);
        return "/admin/comment";
    }

    @GetMapping("/admin/comment/delete")
    @ResponseBody
    public Result CommentDelete(int comment_id){
        int i = commentService.CommentDelete(comment_id);
        if(i>0){
          return   ResultGentor.setSUCCESS_RESULT();
        }
        return ResultGentor.setERROR_RESULT(404, "error");
    }
}
