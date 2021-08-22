package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.adminDao.TagsMapper;
import cn.jiawei.blog.pojo.Tags;
import cn.jiawei.blog.service.blogService.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagsServiceImpl implements TagsService {
    @Autowired
    TagsMapper tagsMapper;
    @Override
    public Tags selectOneByName(String tag_name) {
        return tagsMapper.SelectOneByName(tag_name);
    }

    @Override
    public Integer insertOneTag(Tags tags) {
       return tagsMapper.InsertOneTag(tags);
    }
}
