package cn.jiawei.blog.service.blogService;

import cn.jiawei.blog.pojo.Tags;
import cn.jiawei.blog.pojo.vo.TagsVO;

public interface TagsService {
    Tags selectOneByName(String tag_name);
    Integer insertOneTag(Tags tags);
    TagsVO TAGS_VO();
}
