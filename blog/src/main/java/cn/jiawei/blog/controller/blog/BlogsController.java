package cn.jiawei.blog.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogsController {
    @RequestMapping("/blogs")
    public String blogs(){
        return "blogs";
    }
}
