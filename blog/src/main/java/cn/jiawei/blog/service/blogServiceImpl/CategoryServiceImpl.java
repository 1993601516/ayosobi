package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.adminDao.CategoryMapper;
import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.Category;
import cn.jiawei.blog.service.blogService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public Category selectOneByname(String category_name) {
        return categoryMapper.SelectOneByName(category_name);
    }

    @Override
    public List<String> ListCategoryNames(List<Blog> blogs) {
        List<String> stringList = new ArrayList<>();
        for (Blog blog : blogs) {
            Category category = categoryMapper.SelectPrymaryKey(blog.getBlog_category_id());
            stringList.add(category.getCategory_name());
        }
        return stringList;
    }

    @Override
    public int CategoryCount() {
        return  categoryMapper.CategoryCount();
    }

    @Override
    public List<Category> CATEGORY_LIST() {
        return categoryMapper.SelectListCategory();
    }
}
