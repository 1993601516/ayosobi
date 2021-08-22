package cn.jiawei.blog.service.blogService;

import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.LoginUser;

import java.util.List;

public interface LoginUserService {
    LoginUser queryByname(String username,String password);
    List<String> queryByrealname(List<Blog> blogs);
}
