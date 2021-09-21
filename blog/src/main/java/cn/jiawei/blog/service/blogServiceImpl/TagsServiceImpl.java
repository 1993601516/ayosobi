package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.adminDao.TagsMapper;
import cn.jiawei.blog.pojo.Pagination;
import cn.jiawei.blog.pojo.Tags;
import cn.jiawei.blog.pojo.vo.TagsVO;
import cn.jiawei.blog.service.blogService.TagsService;
import cn.jiawei.blog.unitl.Page;
import cn.jiawei.blog.unitl.PaginationUntil;
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

    @Override
    public List<Tags> TagPage(int current,int pageCount) {
        Page page = PaginationUntil.CurrentPageSet(current, pageCount);
       return tagsMapper.TagPage(page);
    }

    @Override
    public Pagination TagsComputed(int current, int recodings) {
        Pagination pagination =new Pagination();
        pagination.setRecodings(recodings);
        /*查询博客总条数*/
        int i = tagsMapper.TagsCount();
        /*如果总条数对每页记录数有余则总页数+1*/
        int totalpage = i/recodings;
        if(i%recodings>0){
            ++totalpage;
        }
        /*判断是否在页数之间*/
        if(current<=totalpage && current>=1){
            pagination.setCurrent(current);
        }else if(current<=0){
            /*判断是否小于首页*/
            pagination.setCurrent(1);
        }else if(current>totalpage){
            /*判断是否大于尾页*/
            pagination.setCurrent(totalpage);
        }
        pagination.setTotal(totalpage);
        return pagination;
    }

    @Override
    public int DeleteTag(int tag_id) {
     return tagsMapper.DeleteTag(tag_id);
    }


}
