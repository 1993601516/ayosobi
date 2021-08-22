package cn.jiawei.blog.unitl;

import cn.jiawei.blog.pojo.LoginUser;

public class CurrentUser {
    public static LoginUser CURRENT_REALNAM;

    public static LoginUser getCurrentRealnam() {
        return CURRENT_REALNAM;
    }

    public static void setCurrentRealnam(LoginUser currentRealnam) {
        CURRENT_REALNAM = currentRealnam;
    }

    public CurrentUser() {
    }

}
