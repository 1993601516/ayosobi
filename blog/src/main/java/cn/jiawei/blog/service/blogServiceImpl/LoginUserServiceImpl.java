package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.adminDao.LoginMapper;
import cn.jiawei.blog.pojo.Blog;
import cn.jiawei.blog.pojo.LoginUser;
import cn.jiawei.blog.service.blogService.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginUserServiceImpl implements LoginUserService {
    @Autowired
    LoginMapper loginMapper;
    @Override
    public LoginUser queryByname(String username, String password) {
        String ciphertext = null;
        try {
             ciphertext = DigestUtils.md5DigestAsHex(password.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        LoginUser loginUser = loginMapper.queryByname(username, ciphertext.toUpperCase());
        return loginUser;
    }

    @Override
    public List<String> queryByrealname(List<Blog> blogs) {
        List<String> avatars = new ArrayList<>();
        for (Blog blog : blogs) {
            LoginUser loginUser = loginMapper.queryByrealname(blog.getBlog_author());
            avatars.add(loginUser.getAvatarimg_url());
        }
        return avatars;
    }
}
