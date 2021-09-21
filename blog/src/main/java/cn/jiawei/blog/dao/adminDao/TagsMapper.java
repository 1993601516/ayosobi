package cn.jiawei.blog.dao.adminDao;

import cn.jiawei.blog.pojo.Tags;
import cn.jiawei.blog.unitl.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagsMapper {
    Tags SelectOneByName(String tag_name);
    Integer InsertOneTag(Tags tags);
    List<Tags> selectAll();
    List<Tags> TagPage(Page page);
    int TagsCount();
    int DeleteTag(int tag_id);
}
