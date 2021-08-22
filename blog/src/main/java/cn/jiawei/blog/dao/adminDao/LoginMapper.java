package cn.jiawei.blog.dao.adminDao;

import cn.jiawei.blog.pojo.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface LoginMapper {
    List<LoginUser> queryAll();

    LoginUser queryByname(String username,String password);
    LoginUser queryByrealname(String realname);
}
