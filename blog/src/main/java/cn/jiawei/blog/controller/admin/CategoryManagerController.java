package cn.jiawei.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryManagerController {
    @RequestMapping("/admin/category")
    public String category(){
    return "/admin/category";
    }
}
