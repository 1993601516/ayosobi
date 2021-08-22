package cn.jiawei.blog.service.blogService;

import cn.jiawei.blog.pojo.Category;

public interface CategoryService {
    Category selectOneByname(String category_name);
}
