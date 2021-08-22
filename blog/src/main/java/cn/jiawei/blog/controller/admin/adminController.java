package cn.jiawei.blog.controller.admin;
import cn.jiawei.blog.pojo.LoginUser;
import cn.jiawei.blog.service.blogService.LoginUserService;
import cn.jiawei.blog.unitl.CurrentUser;
import cn.jiawei.blog.unitl.Result;
import cn.jiawei.blog.unitl.ResultGentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class adminController {
    @Autowired
    LoginUserService loginUserService;
    @RequestMapping("/index")
    public String index(){
        return "admin/index";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request,HttpSession session){
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            Result result = ResultGentor.setFAIL_RESULT("用户名或者密码不能为空");
            request.setAttribute("result", result.getMessage());
            return "/admin/login";
        }
        if(!StringUtils.isEmpty(username)&& !StringUtils.isEmpty(password)){
            LoginUser loginUser = loginUserService.queryByname(username, password);
            if(loginUser!=null){
                session.setMaxInactiveInterval(30*60);
                session.setAttribute("loginuser", loginUser);
                CurrentUser.setCurrentRealnam(loginUser);
                return "/admin/index";
            }else{
                session.removeAttribute("loginuser");
                Result result = ResultGentor.setERROR_RESULT(404, "用户名或者密码错误");
                request.setAttribute("result", result.getMessage());
                return "/admin/login";
            }
        }
        return null;
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginuser");
        return "/admin/login";
    }
}
