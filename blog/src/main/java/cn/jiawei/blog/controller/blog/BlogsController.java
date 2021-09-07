package cn.jiawei.blog.controller.blog;

import cn.jiawei.blog.dao.blogDao.ReplyMapper;
import cn.jiawei.blog.pojo.Comment;
import cn.jiawei.blog.pojo.Reply;
import cn.jiawei.blog.service.blogService.CommentService;
import cn.jiawei.blog.service.blogService.ReplyService;
import cn.jiawei.blog.unitl.Result;
import cn.jiawei.blog.unitl.ResultGentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogsController {
    @Autowired
    CommentService commentService;
    @Autowired
    ReplyService replyService;
    @RequestMapping("/blogs")
    public String blogs(){
        return "blogs";
    }
    @ResponseBody
    @RequestMapping("/InsertComment")
    public Result InsertComment(Comment comment){
        int result = commentService.InsertOneComment(comment);
        if(result>0){
          return ResultGentor.setSUCCESS_RESULT("success");
        }else {
          return ResultGentor.setFAIL_RESULT("fail");
        }
    }
    @ResponseBody
    @RequestMapping("/InsertReply")
    public Result InsertReply(Reply reply,
                              @RequestParam("replyname") String replyname){
        int result = replyService.InsertReply(reply,replyname);
        if(result>0){
            return ResultGentor.setSUCCESS_RESULT("success");
        }else{
            return ResultGentor.setFAIL_RESULT("fail");
        }
    }
}
