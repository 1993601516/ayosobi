package cn.jiawei.blog.service.blogService;

import cn.jiawei.blog.pojo.Pagination;
import cn.jiawei.blog.pojo.Tags;
import cn.jiawei.blog.pojo.vo.TagsVO;
import cn.jiawei.blog.unitl.Page;

import java.util.List;

public interface TagsService {
    Tags selectOneByName(String tag_name);
    Integer insertOneTag(Tags tags);
    TagsVO TAGS_VO();
    List<Tags> TagPage(int current,int pageCount);
    Pagination TagsComputed(int current,int pageCount);
    int DeleteTag(int tag_id);
}
