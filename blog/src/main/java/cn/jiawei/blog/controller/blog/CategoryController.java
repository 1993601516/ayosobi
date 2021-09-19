package cn.jiawei.blog.controller.blog;

import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.Category;
import cn.jiawei.blog.service.blogService.BlogService;
import cn.jiawei.blog.service.blogService.CategoryService;
import cn.jiawei.blog.service.blogService.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    BlogService blogService;
    @Autowired
    LoginUserService loginUserService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category/{category_id}")
    public String category(Model model,@PathVariable int category_id){
        List<Blog> blogs = blogService.selctListBlogByCategoryId(category_id);
        List<String> avatars = loginUserService.queryByrealname(blogs);
        List<String> categories_names =categoryService.ListCategoryNames(blogs);
        List<Category> category_list = categoryService.CATEGORY_LIST();
        /*所有博客*/
        model.addAttribute("blogs", blogs);
        /*所有头像*/
        model.addAttribute("avatars", avatars);
        /*分类排序*/
        model.addAttribute("categories", categories_names);
        /*分类计数*/
        model.addAttribute("categoryCount", categoryService.CategoryCount());
        /*所有分类*/
        model.addAttribute("category_list", category_list);
        return "/category";
    }
}
