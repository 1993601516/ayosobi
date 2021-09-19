package cn.jiawei.blog.service.blogService;

import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.Category;

import java.util.List;

public interface CategoryService {
    Category selectOneByname(String category_name);
    List<String> ListCategoryNames(List<Blog> blogs);
    int CategoryCount();
    List<Category> CATEGORY_LIST();
}
