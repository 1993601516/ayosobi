package cn.jiawei.blog.controller.blog;

import cn.jiawei.blog.dao.adminDao.CategoryMapper;
import cn.jiawei.blog.pojo.*;
import cn.jiawei.blog.pojo.vo.ArticleVO;
import cn.jiawei.blog.pojo.vo.TagsVO;
import cn.jiawei.blog.service.blogService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    CategoryService categoryService;
    @Autowired
    TagsService tagsService;
    @GetMapping("/")
    public String index(Model model){
        /*分页blogs*/
        List<Blog> blogs = blogService.BlogPages(1, 5,1);
        /*查询所有blog*/
        List<Blog> list = blogService.SelectByAll();
        /*近期热门*/
        ArticleVO articleVO = blogService.Instantiation(list);
        List<String> avatars = loginUserService.queryByrealname(blogs);
        Pagination pagination = blogService.ComputedPagination(1, 5);
        List<String> categories_names =categoryService.ListCategoryNames(blogs);
        TagsVO tagsVO = tagsService.TAGS_VO();
        List<Category> category_list = categoryService.CATEGORY_LIST();
        model.addAttribute("avatars", avatars);
        model.addAttribute("blogs", blogs);
        model.addAttribute("categories", categories_names);
        model.addAttribute("articleVO", articleVO);
        model.addAttribute("categoryCount", categoryService.CategoryCount());
        model.addAttribute("tagsVO", tagsVO);
        model.addAttribute("category_list", category_list);
        model.addAttribute("pagination", pagination);
        return "/index";
    }

    @GetMapping("/page/{current}/{pageCount}")
    public String index(Model model,
                        @PathVariable int current,
                        @PathVariable  int pageCount){
        List<Blog> blogs = blogService.BlogPages(current, pageCount,1);
        List<String> avatars = loginUserService.queryByrealname(blogs);
        Pagination pagination = blogService.ComputedPagination(current, pageCount);
        List<String> categories_names =categoryService.ListCategoryNames(blogs);
        /*查询所有blog*/
        List<Blog> list = blogService.SelectByAll();
        ArticleVO articleVO = blogService.Instantiation(list);
        TagsVO tagsVO = tagsService.TAGS_VO();
        List<Category> category_list = categoryService.CATEGORY_LIST();
        model.addAttribute("avatars", avatars);
        model.addAttribute("blogs", blogs);
        model.addAttribute("categories", categories_names);
        model.addAttribute("articleVO", articleVO);
        model.addAttribute("categoryCount", categoryService.CategoryCount());
        model.addAttribute("tagsVO", tagsVO);
        model.addAttribute("category_list", category_list);
        model.addAttribute("pagination", pagination);
        return "/index";
    }
    /*博客具体内容*/
    @GetMapping("/blog/{blog_id}")
    public String blog(Model model,
                       @PathVariable int blog_id){
        Blog blog = blogService.SelectByPrimarykey(blog_id);
        List<Comment> comments = commentService.SelectByCommentList(blog_id);
        List<List<Reply>> replyLists = replyService.selectByReplyLists(comments);
        String author_avatar = blogService.SelectByPrimaryKey(blog);
        model.addAttribute("blog", blog);
        model.addAttribute("comments", comments);
        model.addAttribute("replyLists", replyLists);
        model.addAttribute("avatar",author_avatar);
        return "/blogs";
    }
    /*通过带有此标签的博客*/
    @GetMapping("/blog/tag/{tag_name}")
    public String TagBLog(Model model,
                          @PathVariable String tag_name){
        List<Blog> blogs = blogService.ListBlogByTag(tag_name);
        List<String> avatars = loginUserService.queryByrealname(blogs);
        List<String> categories_names =categoryService.ListCategoryNames(blogs);
        TagsVO tagsVO = tagsService.TAGS_VO();
        model.addAttribute("blogs", blogs);
        model.addAttribute("avatars", avatars);
        model.addAttribute("categories", categories_names);
        model.addAttribute("tagsVO", tagsVO);
        return "/blog_tag";
    }
}
