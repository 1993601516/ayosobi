package cn.jiawei.blog.unitl;

import cn.jiawei.blog.pojo.Blog;

import java.util.ArrayList;
import java.util.List;

public class toTextGentor {
    public static List<Blog> toText(List<Blog> blogs){
        List<Blog> blogList = new ArrayList<>();
        for (Blog blog : blogs) {
            if(blog.getBlog_status()==1){
                blog.setBlog_content(mdToHtml.HtmltoText(blog.getBlog_content()));
                blogList.add(blog);
            }
        }
        return blogList;
    }
}
