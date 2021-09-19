package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.adminDao.TagsMapper;
import cn.jiawei.blog.pojo.Tags;
import cn.jiawei.blog.pojo.vo.TagsVO;
import cn.jiawei.blog.service.blogService.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public TagsVO TAGS_VO() {
        TagsVO tagsVO =new TagsVO();
        List<String> tagName =new ArrayList<>();
        List<Tags> tags = tagsMapper.selectAll();
        for (Tags tag : tags) {
            tagName.add(tag.getTag_name());
        }
        tagsVO.setTagsNames(tagName);
        tagsVO.setTagsCount(tagsMapper.TagsCount());
        return tagsVO;
    }


}
