package cn.jiawei.blog.service.blogService;

import cn.jiawei.blog.pojo.Tags;

public interface TagsService {
    Tags selectOneByName(String tag_name);
    Integer insertOneTag(Tags tags);
}
