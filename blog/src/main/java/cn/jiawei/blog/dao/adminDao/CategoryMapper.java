package cn.jiawei.blog.dao.adminDao;

import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    Category SelectOneByName(String category_name);
    List<Category> SelectListCategory();
    Category SelectPrymaryKey(int category_id);
    int CategoryCount();
}
