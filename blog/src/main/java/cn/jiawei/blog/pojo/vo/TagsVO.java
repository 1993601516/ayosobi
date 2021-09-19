package cn.jiawei.blog.pojo.vo;

import java.util.List;

public class TagsVO {
    private int TagsCount;
    private List<String> TagsNames;

    public int getTagsCount() {
        return TagsCount;
    }

    public void setTagsCount(int tagsCount) {
        TagsCount = tagsCount;
    }

    public List<String> getTagsNames() {
        return TagsNames;
    }

    public void setTagsNames(List<String> tagsNames) {
        TagsNames = tagsNames;
    }

    public TagsVO(int tagsCount, List<String> tagsNames) {
        TagsCount = tagsCount;
        TagsNames = tagsNames;
    }

    public TagsVO() {
    }
}
