package cn.jiawei.blog.dao.adminDao;

import cn.jiawei.blog.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CategoryMapper {
    Category SelectOneByName(String category_name);
}
