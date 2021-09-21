package cn.jiawei.blog.controller.admin;

import cn.jiawei.blog.dao.adminDao.TagsMapper;
import cn.jiawei.blog.pojo.Pagination;
import cn.jiawei.blog.pojo.Tags;
import cn.jiawei.blog.service.blogService.TagsService;
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
public class TagController {
    @Autowired
    TagsService tagsService;
    @RequestMapping("/admin/tag")
    public String tag(Model model){
        List<Tags> tags = tagsService.TagPage(1, 10);
        Pagination pagination = tagsService.TagsComputed(1, 10);
        model.addAttribute("pagination", pagination);
        model.addAttribute("tags", tags);
        return "/admin/tag";
    }

    @GetMapping("/admin/tag/{current}/{pageCount}")
    public String tag(Model model,
                      @PathVariable int current,
                      @PathVariable int pageCount){
        List<Tags> tags = tagsService.TagPage(current, pageCount);
        Pagination pagination = tagsService.TagsComputed(current, pageCount);
        model.addAttribute("pagination", pagination);
        model.addAttribute("tags", tags);
        return "/admin/tag";
    }

    @GetMapping("/admin/tag/delete")
    @ResponseBody
    public Result tagDelete(int tag_id){
        if(tagsService.DeleteTag(tag_id)>0){
            return ResultGentor.setSUCCESS_RESULT();
        }
        return ResultGentor.setERROR_RESULT(404, "error");
    }
}
