package cn.jiawei.blog.controller.admin;

import cn.jiawei.blog.pojo.Pagination;
import cn.jiawei.blog.pojo.Reply;
import cn.jiawei.blog.service.blogService.ReplyService;
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
public class ReplyController {
    @Autowired
    ReplyService replyService;
    @RequestMapping("/admin/reply/{comment_id}")
    public String reply(Model model,
                        @PathVariable int comment_id){
        List<Reply> replies = replyService.ReplyPage(1, 8,comment_id);
            Pagination pagination = replyService.ReplyComputed(1, 8,comment_id);
            model.addAttribute("comment_id", comment_id);
            model.addAttribute("replies", replies);
            model.addAttribute("pagination", pagination);
        return "/admin/reply";
    }

    @GetMapping("/admin/reply/{current}/{pageCount}/{comment_id}")
    public String reply(Model model,
                        @PathVariable int current,
                        @PathVariable int pageCount,
                        @PathVariable int comment_id){
        List<Reply> replies = replyService.ReplyPage(current, pageCount,comment_id);
        Pagination pagination = replyService.ReplyComputed(current, pageCount,comment_id);
        model.addAttribute("replies", replies);
        model.addAttribute("pagination", pagination);
        model.addAttribute("comment_id", comment_id);
        return "/admin/reply";
    }

    @GetMapping("/admin/reply/delete")
    @ResponseBody
    public Result replyDelete(int reply_id){
        int result = replyService.ReplyDeleteByReplyId(reply_id);
        if(result>0){
          return ResultGentor.setSUCCESS_RESULT();
        }
        return ResultGentor.setERROR_RESULT(404, "error");
    }
}
