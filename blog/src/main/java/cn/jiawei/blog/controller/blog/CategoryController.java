package cn.jiawei.blog.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @RequestMapping("/category")
    public String category(){
        return "category";
    }
}
