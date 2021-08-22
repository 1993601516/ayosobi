package cn.jiawei.blog.dao.adminDao;

import cn.jiawei.blog.pojo.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TagsMapper {
    Tags SelectOneByName(String tag_name);
    Integer InsertOneTag(Tags tags);
}
