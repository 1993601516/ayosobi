package cn.jiawei.blog.controller.admin;

import cn.jiawei.blog.dao.adminDao.CategoryMapper;
import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.Category;
import cn.jiawei.blog.pojo.Pagination;
import cn.jiawei.blog.service.blogService.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryMapper categoryMapper;
    @RequestMapping("/admin/blog")
    public String blog(Model model){
        /*查询首页*/
        List<Blog> blogs = blogService.BlogPages(1, 5,2);
        /*设置page信息*/
        Pagination pagination = blogService.ComputedPagination(1, 5);
        model.addAttribute("blogs", blogs);
        model.addAttribute("pagination", pagination);
        return "/admin/blog";
    }
    @GetMapping("/admin/blog/{current}/{pageCount}")
    public String blog(Model model,
                       @PathVariable int current,
                       @PathVariable int pageCount){
        /*查询博客*/
        List<Blog> blogs = blogService.BlogPages(current, pageCount,2);
        Pagination pagination = blogService.ComputedPagination(current, pageCount);
        model.addAttribute("blogs", blogs);
        model.addAttribute("pagination", pagination);
        return "/admin/blog";
    }
    @GetMapping("/admin/update/{blog_id}")
    public String blogUpdate(Model model,
                             @PathVariable int blog_id){
     /*根据id查询到Blog*/
        Blog blog = blogService.SelectByPrimarykey(blog_id);
        Category category = categoryMapper.SelectPrymaryKey(blog.getBlog_category_id());
        List<Category> categories = categoryMapper.SelectListCategory();
        model.addAttribute("blog", blog);
        model.addAttribute("category",category);
        model.addAttribute("categories", categories);
        return "/admin/articleUpdate";
    }
}
