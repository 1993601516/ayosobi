package cn.jiawei.blog.dao.adminDao;

import cn.jiawei.blog.pojo.Images;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ImagesMapper {
    int SelectCount();
    Images selectByPrimaryKey(int img_id);
    int InsertOneImg(String img_url);
}
