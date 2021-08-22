package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.adminDao.CategoryMapper;
import cn.jiawei.blog.pojo.Category;
import cn.jiawei.blog.service.blogService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public Category selectOneByname(String category_name) {
        return categoryMapper.SelectOneByName(category_name);
    }
}
